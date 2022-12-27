package com.learn.rabbitmqspringboot.m2;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

/**
 * 工作模式
 * 轮询的方式发给消费者，弊端：当某一个消费者正在处理一个耗时很长的消息时(或者直接阻塞)，后面轮发过来消费者要等待前面的执行完而造成消息堆积
 */
@Component
public class Producer {
    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 自定义消息发送方法
     */
    public void send() {
        while (true) {
            System.out.println("输入消息：");
            String s = new Scanner(System.in).nextLine();
            amqpTemplate.convertAndSend("task_queue", s); //自动把message转换成Byte[]数组
        }
    }

}
