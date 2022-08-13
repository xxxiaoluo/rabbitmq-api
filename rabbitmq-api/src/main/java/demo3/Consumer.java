package demo3;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeoutException;

public class Consumer {
    public static void main(String[] args) throws IOException, TimeoutException {
        //连接
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.64.100");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        Channel channel = connectionFactory.newConnection().createChannel();

        //1.创建随机队列  2.创建交换机  3.绑定交换机和队列

        String queueName = UUID.randomUUID().toString();
        channel.queueDeclare(queueName, false, false, false, null); //非持久，独占，自动删除
        channel.exchangeDeclare("Logs", BuiltinExchangeType.FANOUT);
        channel.queueBind(queueName, "Logs", ""); //第三个参数对fanout无效

        //回调对象(处理消息)
        DeliverCallback deliverCallback = (consumerTag, message) -> {
            String s = new String(message.getBody());
            System.out.println("收到：" + s);
        };
        CancelCallback cancelCallback = consumerTag -> {};

        //消息消费(接收消息)
        channel.basicConsume(queueName, true, deliverCallback, cancelCallback);
    }
}