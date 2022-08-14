package demo5;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

public class Consumer {
    public static void main(String[] args) throws IOException, TimeoutException {
        //连接
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.64.100");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        connectionFactory.setVirtualHost("roy-virtual-host-test"); //指定其中一个空间 即虚拟主机
        Channel channel = connectionFactory.newConnection().createChannel();

        // 1.随机队列 2.交换机 3.使用绑定键绑定
        // c.queueDeclare(queue, false,true,true,null);
        // 由服务器来自动随机命名,非持久,独占,自动删除  (这两个queueDeclare区别：下面的队列名字是系统随机创建，上面是自己指定的)
        String queue = channel.queueDeclare().getQueue();//创建队列并获取名字
        channel.exchangeDeclare("topic_logs", BuiltinExchangeType.TOPIC);

        System.out.println("输入绑定键,用空格隔开："); // “ aa bb cc ”
        String s = new Scanner(System.in).nextLine();
        String[] splitStr = s.split("\\s+");// \\s ：\s空白字符,另一个\是转义。  + : aa和bb之间可以有一到多个空白字符。  把分隔开的数据放到数组
        for(String a : splitStr){
            channel.queueBind(queue, "topic_logs", a);
        }

        //回调对象
        DeliverCallback deliverCallback = (consumerTag, message) -> {
            String s1 = new String(message.getBody());
            System.out.println("收到："+s1);
        };
        CancelCallback cancelCallback = consumerTag -> {};

        //消费数据
        channel.basicConsume(queue, true, deliverCallback, cancelCallback);
    }
}
