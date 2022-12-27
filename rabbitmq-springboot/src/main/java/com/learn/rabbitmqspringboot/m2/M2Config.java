package com.learn.rabbitmqspringboot.m2;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class M2Config {

    @Bean
    public Queue taskQueue(){
        return new Queue("task_queue"); //后面参数默认 true,false,false
    }
}
