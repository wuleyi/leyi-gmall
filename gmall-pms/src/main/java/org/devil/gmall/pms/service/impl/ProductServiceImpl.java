package org.devil.gmall.pms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.CaseFormat;
import org.devil.gmall.pms.entity.Product;
import org.devil.gmall.pms.mapper.ProductMapper;
import org.devil.gmall.pms.service.ProductService;
import org.devil.gmall.pms.vo.PmsProductQueryVo;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 商品信息 服务实现类
 * </p>
 *
 * @author Leyi
 * @since 2019-06-08
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Override
    public Map<String, Object> listProductByCondition(PmsProductQueryVo productQueryVo, Integer pageSize, Integer pageNum) {

        Page<Product> productPage = new Page<>(pageNum, pageSize);

        QueryWrapper<Product> productQueryWrapper = new QueryWrapper<>();

        if (productQueryVo != null) {
            Arrays.asList(productQueryVo.getClass().getDeclaredFields()).forEach(field -> {
                field.setAccessible(true);
                Object fieldVal = null;
                try {
                    fieldVal = field.get(productQueryVo);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                if (!StringUtils.isEmpty(fieldVal)) {
                    String columnName = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, field.getName());
                    productQueryWrapper.eq(columnName, fieldVal);
                }
            });
        }

        baseMapper.selectPage(productPage, productQueryWrapper);

        Map<String, Object> pageMap = new HashMap<>();
        pageMap.put("pageSize", productPage.getSize());
        pageMap.put("totalPage", productPage.getPages());
        pageMap.put("total", productPage.getTotal());
        pageMap.put("pageNum", productPage.getCurrent());
        pageMap.put("list", productPage.getRecords());
        return pageMap;
    }

}
