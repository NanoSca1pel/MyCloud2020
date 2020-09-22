package com.lht.springcloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lht.springcloud.entity.Order;

/**
 * @author lhtao
 * @date 2020/9/22 10:08
 */
public interface OrderService extends IService<Order> {

    void create(Order order);
}
