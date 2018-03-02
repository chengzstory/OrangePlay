package com.chengzstory.orangeplay.service.impl;

import com.chengzstory.orangeplay.entity.Orderitem;
import com.chengzstory.orangeplay.mapper.OrderitemMapper;
import com.chengzstory.orangeplay.service.OrderitemService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 每个订单对应的订单详细内容 服务实现类
 * </p>
 *
 * @author chengzstroy
 * @since 2018-02-28
 */
@Service
public class OrderitemServiceImpl extends ServiceImpl<OrderitemMapper, Orderitem> implements OrderitemService {

}
