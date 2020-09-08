package com.lht.springcloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lht.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author lhtao
 * @date 2020/9/2 11:30
 */
@Mapper
public interface PaymentMapper extends BaseMapper<Payment> {

}
