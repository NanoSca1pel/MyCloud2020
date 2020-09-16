package com.lht.springcloud.controller;

import com.lht.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lhtao
 * @date 2020/9/16 14:38
 */
@RestController
@RequestMapping("/msg")
@Slf4j
public class SendMessageController {

    @Autowired
    private IMessageProvider iMessageProvider;

    @GetMapping("/sendMsg")
    public void sendMessage() {
        iMessageProvider.send();
    }
}
