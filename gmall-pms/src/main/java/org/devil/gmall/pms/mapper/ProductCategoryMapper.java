package org.devil.gmall.pms.mapper;

import org.devil.gmall.pms.entity.ProductCategory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.devil.gmall.pms.vo.PmsProductMultiCategoryVo;

import java.util.List;

/**
 * <p>
 * 产品分类 Mapper 接口
 * </p>
 *
 * @author Leyi
 * @since 2019-06-08
 */
public interface ProductCategoryMapper extends BaseMapper<ProductCategory> {

    List<PmsProductMultiCategoryVo> selectWithChild(Integer i);

}
