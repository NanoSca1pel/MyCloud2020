package com.lht.springcloud.service;

import java.math.BigDecimal;

/**
 * @author lhtao
 * @date 2020/9/22 10:14
 */
public interface AccountService {

    void decrease(Long userId, BigDecimal money);
}
