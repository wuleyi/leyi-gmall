package org.devil.gmall.oms.service.impl;

import org.devil.gmall.oms.entity.OrderItem;
import org.devil.gmall.oms.mapper.OrderItemMapper;
import org.devil.gmall.oms.service.OrderItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单中所包含的商品 服务实现类
 * </p>
 *
 * @author Leyi
 * @since 2019-06-08
 */
@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem> implements OrderItemService {

}
