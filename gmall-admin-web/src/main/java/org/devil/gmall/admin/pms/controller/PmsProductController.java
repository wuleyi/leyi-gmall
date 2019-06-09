package org.devil.gmall.admin.pms.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.extension.api.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.devil.gmall.pms.service.ProductService;
import org.devil.gmall.pms.vo.PmsProductQueryVo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by leyi on 2019/6/9.
 */
@CrossOrigin
@RestController
@RequestMapping("/product")
@Api(tags = "PmsProductController", description = "商品管理")
public class PmsProductController {

    @Reference
    private ProductService productService;

    @ApiOperation("带条件的分页查询商品")
    @GetMapping("/list")
    public R listProduct(PmsProductQueryVo productQueryVo,
                         @ApiParam(value = "每页展示记录数", defaultValue = "5") Integer pageSize,
                         @ApiParam(value = "指定访问页", defaultValue = "1") Integer pageNum) {

        return R.ok(productService.listProductByCondition(productQueryVo, pageSize, pageNum)).setCode(200);
    }

}
