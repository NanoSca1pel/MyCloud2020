package com.lht.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lht.springcloud.entity.CommonResult;
import com.lht.springcloud.entity.Payment;

/**
 * @author lhtao
 * @date 2020/9/18 15:21
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException1(BlockException exception) {
        return new CommonResult(444, "按照客户自定义的Global 全局处理异常 -------- 1" , new Payment(2022L,"serial003"));
    }

    public static CommonResult handlerException2(BlockException exception) {
        return  new CommonResult(444,"按照客户自定义的Global 全局异常处理 ---- 2",new Payment(2022L,"serial003"));
    }
}
