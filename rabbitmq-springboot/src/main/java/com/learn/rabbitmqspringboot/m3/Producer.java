package com.learn.rabbitmqspringboot.m3;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

/**
 * 发布订阅模式
 * 实现群发
 * 轮询的方式发给消费者，弊端：当某一个消费者正在处理一个耗时很长的消息时(或者直接阻塞)，后面轮发过来要等待前面的执行完而造成消息堆积
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
            //对于扇形交换机而言第二个参数(队列名)是无效的，发布订阅就是要让所有队列都收到消息，指定队列就没了意义,给空字符串就好
            amqpTemplate.convertAndSend("logs","", s); // 交换机,队列名,消息

        }
    }

}
