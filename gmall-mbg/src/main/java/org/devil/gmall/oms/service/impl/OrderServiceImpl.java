package org.devil.gmall.oms.service.impl;

import org.devil.gmall.oms.entity.Order;
import org.devil.gmall.oms.mapper.OrderMapper;
import org.devil.gmall.oms.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author Leyi
 * @since 2019-06-08
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}
