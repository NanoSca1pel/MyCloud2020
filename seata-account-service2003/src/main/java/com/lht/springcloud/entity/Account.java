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
@TableName("t_account")
public class Account extends Model<Account> {

    private Long id;

    private Long userId;

    private BigDecimal total;

    private BigDecimal used;

    private BigDecimal residue;
}