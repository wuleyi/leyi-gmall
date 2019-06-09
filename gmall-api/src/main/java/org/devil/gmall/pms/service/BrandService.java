package org.devil.gmall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.devil.gmall.pms.entity.Brand;

import java.util.Map;

/**
 * <p>
 * 品牌表 服务类
 * </p>
 *
 * @author Leyi
 * @since 2019-06-08
 */
public interface BrandService extends IService<Brand> {

    Map<String, Object> listBrand(String keywords, Integer pageNum, Integer pageSize);

}
