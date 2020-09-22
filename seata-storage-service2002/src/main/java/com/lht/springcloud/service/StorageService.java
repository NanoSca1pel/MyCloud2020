package com.lht.springcloud.service;

/**
 * @author lhtao
 * @date 2020/9/22 10:14
 */
public interface StorageService {

    void decrease(Long productId, Integer count);
}
