package com.lht.springcloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lht.springcloud.entity.Order;
import com.lht.springcloud.mapper.OrderMapper;
import com.lht.springcloud.service.AccountService;
import com.lht.springcloud.service.OrderService;
import com.lht.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lhtao
 * @date 2020/9/22 10:11
 */
@Service
@Slf4j
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private AccountService accountService;

    @Autowired
    private StorageService storageService;

    /**
     * 创建订单->调用库存服务扣减库存->调用账户服务扣减账户余额->修改订单状态
     * 简单说:
     * 下订单->减库存->减余额->改状态
     * GlobalTransactional seata开启分布式事务,异常时回滚,name保证唯一即可
     * @param order 订单对象
     */
    @Override
    @GlobalTransactional(name = "fs_create_order", rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("-----------> 开始新建订单");
        //新建订单
        //orderMapper.insert(order);
        order.insert(); //实体类继承Model类后可用的方法

        log.info("-----------> 订单微服务开始调用库存，做扣减 start");
        //扣减库存
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("-----------> 订单微服务开始调用库存，做扣减 end");

        log.info("-----------> 订单微服务开始调用账户，做扣减 start");
        //扣减金额
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("-----------> 订单微服务开始调用账户，做扣减 end");

        log.info("-----------> 修改订单状态 start");
        //修改订单状态 1代表已完成
        //LambdaUpdateWrapper<Order> updateWrapper = new UpdateWrapper<Order>().lambda();
        //updateWrapper.eq(Order::getId, order.getId()).set(Order::getStatus, 1);
        //orderMapper.update(order, updateWrapper);
        order.setStatus(1);
        order.updateById();
        log.info("-----------> 修改订单状态 end");

        log.info("-----------> 下订单结束了，(๐॔˃̶ᗜ˂̶๐॓)");
    }
}
