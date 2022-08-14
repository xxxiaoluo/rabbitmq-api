package demo5;


import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * 主题模式: 使用 topic 类型交换机  (和路由模式一样，只是路由模式的键是整个名称进行匹配，主题模式是用)
 * 通过topic类型交换机对指定键的队列发送消息，用消费者一一对应的队列对绑定的键来接收交换机发来的消息
 *
 * 多加了个虚拟主机，rabbitmq服务器里边可以分多个空间（virtual host），每个空间是独立的，单独空间的效果和之前是一致的，也可以创建多个队列等
 */
public class Producer {
    public static void main(String[] args) throws IOException, TimeoutException {
        //连接
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.64.100");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        connectionFactory.setVirtualHost("roy-virtual-host-test"); //指定其中一个空间 即虚拟主机
        Channel channel = connectionFactory.newConnection().createChannel();

        //创建 direct 交换机
        channel.exchangeDeclare("topic_logs", BuiltinExchangeType.TOPIC);

        //向指定交换机发送消息,携带路由键关键词
        while(true){
            System.out.println("输入消息：");
            String messageInfo = new Scanner(System.in).nextLine();
            System.out.println("请输入路由键：");
            String routeKey = new Scanner(System.in).nextLine();

            //direct 类型交换机, basicPublish第二个参数是路由键。默认交换机的第二个参数是队列名
            channel.basicPublish("topic_logs", routeKey, null, messageInfo.getBytes());
        }
    }
}
