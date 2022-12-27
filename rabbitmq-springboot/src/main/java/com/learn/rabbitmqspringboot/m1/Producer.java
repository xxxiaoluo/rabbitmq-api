package com.learn.rabbitmqspringboot.m1;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 简单模式
 */
@Component
public class Producer {
    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 自定义消息发送方法
     * amqpTemplate.convertAndSend 此方法发送的消息，默认就是持久消息
     */
    public void send(){
        amqpTemplate.convertAndSend("helloworld", "Roy msg 来啦"); //自动把message转换成Byte[]数组
    }

}
