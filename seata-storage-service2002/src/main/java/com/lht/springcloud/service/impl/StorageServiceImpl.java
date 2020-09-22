package com.lht.springcloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lht.springcloud.entity.Storage;
import com.lht.springcloud.mapper.StorageMapper;
import com.lht.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lhtao
 * @date 2020/9/22 10:11
 */
@Service
@Slf4j
public class StorageServiceImpl extends ServiceImpl<StorageMapper, Storage> implements StorageService {

    @Autowired
    private StorageMapper storageMapper;


    @Override
    public void decrease(Long productId, Integer count) {
        log.info("----> storage-service中扣减库存开始");
        UpdateWrapper<Storage> updateWrapper = new UpdateWrapper<Storage>();
        updateWrapper.setSql("used = used + " + count + ", residue = residue - " + count).apply("product_id = {0} ", productId);
        Storage storage = new Storage();
        storageMapper.update(storage,updateWrapper);
        log.info("----> storage-service中扣减库存结束");
    }
}
