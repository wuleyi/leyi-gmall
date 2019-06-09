package org.devil.gmall.admin.ums.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.extension.api.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.devil.gmall.admin.util.JwtTokenUtils;
import org.devil.gmall.ums.entity.Admin;
import org.devil.gmall.ums.service.AdminService;
import org.devil.gmall.ums.vo.UmsAdminLoginVo;
import org.devil.gmall.ums.vo.UmsAdminRegistryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by leyi on 2019/6/8.
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/admin")
@Api("后台用户管理")
public class UmsAdminController {

    @Reference
    AdminService adminService;

    @Autowired
    JwtTokenUtils jwtTokenUtils;

    @Value("${gmall.jwt.tokenHead}")
    private String tokenHead;

    @Value("${gmall.jwt.tokenHeader}")
    private String tokenHeader;

    @ApiOperation("获取当前登录用户信息")
    @GetMapping("/info")
    public Object getAdminInfo(HttpServletRequest request) {
        String oldToken = request.getHeader(tokenHeader);

        String token = oldToken.substring(tokenHead.length());
        String userName = jwtTokenUtils.getUserNameFromToken(token);
        System.out.println("访客名：" + userName);

        //MyBatisPlus的service简单方法可以用，复杂的方法（参数是QueryWrapper、参数是IPage的都不要用）
        // Admin umsAdmin = adminService.getOne(new QueryWrapper<Admin>().eq("username",userName));
        Admin umsAdmin = adminService.getAdminByUsername(userName);

        Map<String, Object> data = new HashMap<>();
        data.put("username", umsAdmin.getUsername());
        data.put("roles", new String[]{"TEST"});
        data.put("icon", umsAdmin.getIcon());
        return R.ok(data).setCode(200);
    }

    @ApiOperation("用户注册")
    @PostMapping("registry")
    public R register(@Valid @RequestBody UmsAdminRegistryVo adminRegistryVo, BindingResult result) {

        return R.ok("pass");
    }

    @PostMapping("login")
    @ApiOperation("用户登录，返回jwtToken")
    public R login(@Valid @RequestBody UmsAdminLoginVo adminLoginVo, BindingResult bindingResult) {

        Admin admin = adminService.login(adminLoginVo.getUsername(), adminLoginVo.getPassword());

        if (admin == null) {
            return R.failed("用户名或密码错误");
        }

        // 根据admin对象生成jwt信息
        String jwtToken = jwtTokenUtils.generateToken(admin);

        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", jwtToken);
        tokenMap.put("tokenHead", tokenHead);
        return R.ok(tokenMap).setCode(200);
    }

}
