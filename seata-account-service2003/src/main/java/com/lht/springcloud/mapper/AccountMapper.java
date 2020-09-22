package com.lht.springcloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lht.springcloud.entity.Account;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author lhtao
 * @date 2020/9/22 9:59
 */
@Mapper
public interface AccountMapper extends BaseMapper<Account> {
}
