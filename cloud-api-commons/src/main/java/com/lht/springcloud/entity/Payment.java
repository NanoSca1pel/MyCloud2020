package com.lht.springcloud.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author lhtao
 * @date 2020/9/2 11:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String serial;
}
