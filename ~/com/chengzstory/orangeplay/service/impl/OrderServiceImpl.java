package com.chengzstory.orangeplay.service.impl;

import com.chengzstory.orangeplay.entity.Order;
import com.chengzstory.orangeplay.mapper.OrderMapper;
import com.chengzstory.orangeplay.service.OrderService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author chengzstroy
 * @since 2018-02-28
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}
