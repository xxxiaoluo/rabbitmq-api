package demo2;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;


/**
 * 工作模式：多个消费者从同一队列接收数据，负载均衡，合理地分发消息，消息持久化
 *
 * 消息持久化：为解决rabbitmq挂掉做的措施，在创建队列和发送消息的时候在rabbitmq持久化，在rabbitmq再次启动起来的时候回自动回复消息分发
 */
public class Producer {
    public static void main(String[] args) throws IOException, TimeoutException {
        //连接
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.64.100");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");

        Channel channel = connectionFactory.newConnection().createChannel(); //通信通道

        //创建队列
        /*
            queueDeclare参数注释：
                param1： 创建队列的名称
                param2： 是否是持久队列  false:只存于内存中  true：会存储到磁盘
                param3： 是否是排他队列、独占队列  false：可以被多个消费者服务消费   true：不可被多个消费者消费
                param4： 是否自动删除  false：当没有消费者消费这个队列时服务器不会自动删除这个队列   true：自动删除
                param5： 队列的其他参数属性(为Map类型) 一般没什么其他参数设置为null
         */
        channel.queueDeclare("helloworld3", true, false, false, null);

        //循环数据消息，并发送
        while(true){
            System.out.println("输入消息：");
            String s = new Scanner(System.in).nextLine();
            /*
                basicPublish参数注释：
                    param1: 交换机(不同交换机作用不同),空串是默认的一个交换机 作用：消息是通过交换机发送到队列的
                    param3: 消息的属性数据 没有其他属性就null值
             */
            /*
                持久化队列除了在创建队列的时候设置队列，还要在发送消息的时候设置消息为持久消息 MessageProperties.PERSISTENT_BASIC
             */
            channel.basicPublish("", "helloworld3", MessageProperties.PERSISTENT_BASIC, s.getBytes());
        }
    }
}