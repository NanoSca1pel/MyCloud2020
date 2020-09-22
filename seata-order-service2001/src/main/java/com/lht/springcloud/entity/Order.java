package com.lht.springcloud.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author lhtao
 * @date 2020/9/22 9:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_order")
public class Order extends Model<Order> {

    private Long id;

    private Long userId;

    private Long productId;

    private Integer count;

    private BigDecimal money;

    /** 订单状态 0：创建中 1：已完结 */
    private Integer status;
}