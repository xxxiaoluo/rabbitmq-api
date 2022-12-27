package com.learn.rabbitmqspringboot.m2;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component //让spring自动创建实例 项目中有@Service等
public class Consumer {

    //@RabbitHandler配合@RabbitListener使用  也可以直接在方法上写@RabbitListener，就不用再写@RabbitHandler了。这么写的好处是可以写在多个方法上，也就意味着将有多个消费者
    @RabbitListener(queues = "task_queue")
    public void receive1(String msg){ //自动将Byte[]数组反序列化成字符串
        for (int i = 0; i < msg.length(); i++){
            if(msg.charAt(i) == '.'){
                try{
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
            System.out.println("receive1收到：" + msg);
    }

    @RabbitListener(queues = "task_queue")
    public void receive2(String msg){ //自动将Byte[]数组反序列化成字符串
        System.out.println("receive2收到：" + msg);
    }

    @RabbitListener(queues = "task_queue")
    public void receive3(String msg){ //自动将Byte[]数组反序列化成字符串
        System.out.println("receive3收到：" + msg);
    }
}
