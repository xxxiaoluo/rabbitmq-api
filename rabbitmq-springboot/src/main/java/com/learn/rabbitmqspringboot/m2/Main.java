package com.learn.rabbitmqspringboot.m2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Autowired
    private Producer producer;
    /**
     * 消息合理分发
     *     1. autoAck=false 手动确认
     *        springboot 封装的api，默认就是手动确认模式，springboot会自动发送回执
     *     2. qos=1 每次只收1条
     *        yml 添加 prefetch=1 （默认是 250）
     *
     * 消息的持久化：
     *   AmqpTemplate.convertAndSend(队列,消息,消息预处理对象)
     *       消息预处理对象中，可以获取消息属性，把持久化属性改成非持久，可以发送非持久消息
     */

    /**
     * @PostConstruct ：
     * @PostConstruct是java自带的注解，在方法上加该注解会在项目启动的时候执行该方法，
     * 也可以理解为在spring容器初始化的时候执行该方法。一般用来执行一些初始的应用
     *
     * spring执行流程：
     *包扫描创建所有实例 -- 依赖注入 -- @PostConstruct -- 执行后续流程
     * @param args
     */
    @PostConstruct
    public void test(){
        // 下面用到while死循环 在新的线程中执行死循环，不阻塞spring主线程的执行
        new Thread(() -> producer.send()).start();
    }

}
