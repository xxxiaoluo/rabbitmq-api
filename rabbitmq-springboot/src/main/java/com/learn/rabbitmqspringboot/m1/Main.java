package com.learn.rabbitmqspringboot.m1;

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
        producer.send();
    }

}
