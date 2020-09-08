package com.lht.springcloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lht.springcloud.entity.Payment;
import com.lht.springcloud.mapper.PaymentMapper;
import com.lht.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

/**
 * @author lhtao
 * @date 2020/9/2 16:06
 */
@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, Payment> implements PaymentService {
}
