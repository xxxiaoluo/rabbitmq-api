package com.pd;

import com.pd.pojo.PdOrder;
import com.pd.service.OrderService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * roy添加：
 *
 * OrderConsumer需要让spring自动扫描自动创建实例
 * 创建实例后，通过@RabbitListener自动将OrderConsumer注册成消费者
 * 自动开始从队列接收消息
 * 自动将消息传递到@RabbitHandler方法
 */
@Component
@RabbitListener(queues = "orderQueue") //该注解功能还可以将接收到Byte[]数组序列化对象 反序列化成订单对象
public class OrderConsumer {
    @Autowired
    private OrderService orderService;

    //配合@RabbitListener，用来指定处理消息的方法
    //@RabbitHandler注解只能有一个，不能有多个
    @RabbitHandler
    public void receive(PdOrder pdOrder) throws Exception {
        orderService.saveOrder(pdOrder);
        System.out.println("-----------订单已保存-----------");
    }
}
