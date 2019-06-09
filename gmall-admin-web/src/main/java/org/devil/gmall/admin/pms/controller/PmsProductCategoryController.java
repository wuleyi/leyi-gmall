package org.devil.gmall.admin.pms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.extension.api.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.devil.gmall.pms.service.ProductCategoryService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by leyi on 2019/6/9.
 */
@CrossOrigin
@RestController
@RequestMapping("/productCategory")
@Api(tags = "PmsProductCategoryController", description = "商品分类管理")
public class PmsProductCategoryController {

    @Reference
    ProductCategoryService productCategoryService;

    @ApiOperation("查询所有一级分类及子分类[有难度]")
    @GetMapping(value = "/list/withChildren")
    public R listWithChildren() {

        //查询所有一级分类及子分类
        return R.ok(productCategoryService.listWithChildren()).setCode(200);
    }

}
