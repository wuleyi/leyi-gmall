package org.devil.gmall.admin.pms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.extension.api.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.devil.gmall.pms.service.BrandService;
import org.springframework.web.bind.annotation.*;

/**
 * Created by leyi on 2019/6/9.
 */
@CrossOrigin
@RestController
@RequestMapping("/brand")
@Api(tags = "PmsBrandController", description = "商品品牌管理")
public class PmsBrandController {

    @Reference
    BrandService brandService;

    @GetMapping("list")
    @ApiOperation("获取品牌列表")
    public R listBrand(@RequestParam(required = false) String keywords, Integer pageNum, Integer pageSize) {

        return R.ok(brandService.listBrand(keywords, pageNum, pageSize)).setCode(200);
    }

}
