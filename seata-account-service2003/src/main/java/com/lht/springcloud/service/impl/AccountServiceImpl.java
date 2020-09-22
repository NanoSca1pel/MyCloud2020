package com.lht.springcloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lht.springcloud.entity.Account;
import com.lht.springcloud.mapper.AccountMapper;
import com.lht.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @author lhtao
 * @date 2020/9/22 10:11
 */
@Service
@Slf4j
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("----> account-service中扣减账户余额开始");
        //摸你超时异常，全局事务回滚
        //暂停几秒钟线程
        //try { TimeUnit.SECONDS.sleep(20); } catch(InterruptedException e) { e.printStackTrace(); }

        UpdateWrapper<Account> updateWrapper = new UpdateWrapper<Account>();
        updateWrapper.setSql("used = used + " + money + ", residue = residue - " + money).apply("user_id = {0} ", userId);
        Account account = new Account();
        accountMapper.update(account,updateWrapper);
        log.info("----> account-service中扣减账户余额结束");
    }
}
