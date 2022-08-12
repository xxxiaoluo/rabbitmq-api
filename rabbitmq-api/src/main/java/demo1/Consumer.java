package demo1;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 注意：消费者和生产者谁先启动谁就先创建队列
 */

public class Consumer {
    public static void main(String[] args) throws IOException, TimeoutException {
        //连接
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.64.100");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();//通信通道

        //创建队列
        channel.queueDeclare("helloworld", false, false, false, null);

        //回调对象
        //message消息数据封装的对象
        DeliverCallback deliverCallback = (consumerTag, message) -> {
            byte[] body = message.getBody(); //获取消息体
            String s = new String(body);
            System.out.println(s);
            System.out.println("收到");
        };
        CancelCallback cancelCallback = consumerTag -> {};

        //开始接收消息，消费消息，收到的消息会传递到一个回调对象处理
        //basicConsume("helloworld", true, 处理消息的回调对象, 取消处理消息的回调对象);
        //deliverCallback该参数指定消息处理对象
        channel.basicConsume("helloworld", true,deliverCallback, cancelCallback);

    }
}
