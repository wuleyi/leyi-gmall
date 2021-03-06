package org.devil.gmall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.devil.gmall.pms.entity.Product;
import org.devil.gmall.pms.vo.PmsProductQueryVo;

import java.util.Map;

/**
 * <p>
 * 商品信息 服务类
 * </p>
 *
 * @author Leyi
 * @since 2019-06-08
 */
public interface ProductService extends IService<Product> {

    Map<String, Object> listProductByCondition(PmsProductQueryVo productQueryVo, Integer pageSize, Integer pageNum);

}
