package com.learn.rabbitmqspringboot.m4;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class M4Config {

    //创建交换机(Direct交换机)  spring封装后默认持久
    @Bean
    public DirectExchange taskQueue(){
        return new DirectExchange("direct_logs", false, false); //后面参数默认 非持久,非自动删除
    }
}
