package com.learn.rabbitmqspringboot.m5;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component //让spring自动创建实例 项目中有@Service等
public class Consumer {

    //@RabbitHandler配合@RabbitListener使用  也可以直接在方法上写@RabbitListener，就不用再写@RabbitHandler了。这么写的好处是可以写在多个方法上，也就意味着将有多个消费者

    @RabbitListener(bindings = @QueueBinding( //绑定交换机和队列
            value = @Queue, //自动设置的参数 ： 随机命名，false,true,true  也可以自己给参数
            exchange = @Exchange(name = "topic_logs",declare = "false"), //指定交换机名，不写declare默认为true就会去创建交换机
            key = {"*.orange.*"}
    ))
    public void receive1(String msg){ //自动将Byte[]数组反序列化成字符串
        System.out.println("receive1收到：" + msg);
    }

    // #{} spring 表达式语言    ${}对象图导航语言(struts2里的)
    @RabbitListener(bindings = @QueueBinding( //绑定交换机和队列
            value = @Queue(name = "#{rndQueue.name}",declare = "false"), //自动设置的参数 ： 随机命名，false,true,true  也可以自己给参数
            exchange = @Exchange(name = "topic_logs",declare = "false"), //指定交换机名，不写declare默认为true就会去创建交换机
            key = {"*.*.rabbit","lazy.#"}
    ))
    public void receive2(String msg){ //自动将Byte[]数组反序列化成字符串
        System.out.println("receive2收到：" + msg);
    }

}