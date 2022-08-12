package demo2;

import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
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

        //创建队列
        channel.queueDeclare("helloworld2", false, false, false, null);

        //回调对象(处理消息)
        DeliverCallback deliverCallback = (consumerTag, message) -> {
            String s = new String(message.getBody());
            System.out.println(s);
        };
        CancelCallback cancelCallback = consumerTag -> {};

        //消息消费(接收消息)
        channel.basicConsume("helloworld2", true, deliverCallback, cancelCallback);
    }
}
