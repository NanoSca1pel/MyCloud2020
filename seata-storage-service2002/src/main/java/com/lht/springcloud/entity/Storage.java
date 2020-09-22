package com.lht.springcloud.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lhtao
 * @date 2020/9/22 9:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_storage")
public class Storage extends Model<Storage> {

    private Long id;

    private Long productId;

    private Integer total;

    private Integer used;

    private Integer residue;
}