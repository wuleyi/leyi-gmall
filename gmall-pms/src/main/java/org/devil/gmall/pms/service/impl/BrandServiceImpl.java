package org.devil.gmall.pms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.devil.gmall.pms.entity.Brand;
import org.devil.gmall.pms.mapper.BrandMapper;
import org.devil.gmall.pms.service.BrandService;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 品牌表 服务实现类
 * </p>
 *
 * @author Leyi
 * @since 2019-06-08
 */
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements BrandService {

    @Override
    public Map<String, Object> listBrand(String keywords, Integer pageNum, Integer pageSize) {

        Page<Brand> brandPage = new Page<>(pageNum, pageSize);

        QueryWrapper<Brand> brandQueryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(keywords))
            brandQueryWrapper.like("name", keywords).eq("first_letter",keywords);

        baseMapper.selectPage(brandPage, brandQueryWrapper);

        Map<String, Object> pageMap = new HashMap<>();
        pageMap.put("pageSize", brandPage.getSize());
        pageMap.put("totalPage", brandPage.getPages());
        pageMap.put("total", brandPage.getTotal());
        pageMap.put("pageNum", brandPage.getCurrent());
        pageMap.put("list", brandPage.getRecords());
        return pageMap;
    }

}
