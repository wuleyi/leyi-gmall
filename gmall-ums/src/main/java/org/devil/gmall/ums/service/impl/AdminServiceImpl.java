package org.devil.gmall.ums.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.devil.gmall.ums.entity.Admin;
import org.devil.gmall.ums.mapper.AdminMapper;
import org.devil.gmall.ums.service.AdminService;
import org.springframework.util.DigestUtils;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author Leyi
 * @since 2019-06-08
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Override
    public Admin login(String username, String password) {

        //使用Spring自带的md5工具类加密密码
        String digest = DigestUtils.md5DigestAsHex(password.getBytes());

        return baseMapper.selectOne(new QueryWrapper<Admin>()
                .eq("username", username)
                .eq("password", digest));
    }

    @Override
    public Admin getAdminByUsername(String userName) {

        return baseMapper.selectOne(new QueryWrapper<Admin>().eq("username", userName));
    }

}
