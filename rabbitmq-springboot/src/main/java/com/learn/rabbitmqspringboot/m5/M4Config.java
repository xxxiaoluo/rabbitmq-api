package com.learn.rabbitmqspringboot.m5;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
public class M4Config {

    //创建交换机(Direct交换机)  spring封装后默认持久
    @Bean
    public DirectExchange taskQueue(){
        return new DirectExchange("topic_logs", false, false); //后面参数默认 非持久,非自动删除
    }

    /*
    放入spring容器的对象键值对：
    rndQueue ---- Queue实例
     */
    @Bean
    public Queue rndQueue(){
        return new Queue(UUID.randomUUID().toString(),false,true,true);
    }
}
