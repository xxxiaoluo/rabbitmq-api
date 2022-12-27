package com.learn.rabbitmqspringboot.m1;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class M1Config {

    @Bean
    public Queue helloworld(){
//        return new Queue("helloworld");  //后面参数默认true,false,false
        return new Queue("helloworld", false); //后面参数默认 false,false,false
    }
}
