package com.lht.springcloud.service.impl;

import com.lht.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author lhtao
 * @date 2020/9/16 14:25
 */
@EnableBinding(Source.class)  //定义消息的推送管道
@Slf4j
public class MessageProviderImpl implements IMessageProvider  {

    @Resource
    private MessageChannel output; //消息发送管道

    @Override
    public void send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        log.info("***********serial: "+ serial);
    }
}
