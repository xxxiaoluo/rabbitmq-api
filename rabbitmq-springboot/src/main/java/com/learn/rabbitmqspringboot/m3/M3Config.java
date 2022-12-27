package com.learn.rabbitmqspringboot.m3;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class M3Config {

    //创建交换机(扇形交换机)  spring封装后默认持久
    @Bean
    public FanoutExchange taskQueue(){
        return new FanoutExchange("logs",false,false); //后面参数默认 非持久,非自动删除
    }
}
