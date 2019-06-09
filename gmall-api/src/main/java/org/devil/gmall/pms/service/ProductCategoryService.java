package org.devil.gmall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.devil.gmall.pms.entity.ProductCategory;
import org.devil.gmall.pms.vo.PmsProductMultiCategoryVo;

import java.util.List;

/**
 * <p>
 * 产品分类 服务类
 * </p>
 *
 * @author Leyi
 * @since 2019-06-08
 */
public interface ProductCategoryService extends IService<ProductCategory> {

    List<PmsProductMultiCategoryVo> listWithChildren();

}
