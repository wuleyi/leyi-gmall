package org.devil.gmall.pms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.devil.gmall.pms.entity.ProductCategory;
import org.devil.gmall.pms.mapper.ProductCategoryMapper;
import org.devil.gmall.pms.service.ProductCategoryService;
import org.devil.gmall.pms.vo.PmsProductMultiCategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.List;

/**
 * <p>
 * 产品分类 服务实现类
 * </p>
 *
 * @author Leyi
 * @since 2019-06-08
 */
@Service
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryMapper, ProductCategory> implements ProductCategoryService {

    @Autowired
    StringRedisTemplate redisTemplate;

    @Override
    public List<PmsProductMultiCategoryVo> listWithChildren() {

        ValueOperations<String, String> valueOptions = redisTemplate.opsForValue();

        List<PmsProductMultiCategoryVo> productMultiCategoryVoList = baseMapper.selectWithChild(0);
        return productMultiCategoryVoList;
    }
}
