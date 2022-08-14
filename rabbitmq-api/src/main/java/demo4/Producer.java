package demo4;


import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * 路由模式: 使用 direct 类型交换机
 * 通过direct类型交换机对指定键的队列发送消息，用消费者一一对应的队列对绑定的键来接收交换机发来的消息
 */
public class Producer {
    public static void main(String[] args) throws IOException, TimeoutException {
        //连接
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.64.100");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        Channel channel = connectionFactory.newConnection().createChannel();

        //创建 direct 交换机
        channel.exchangeDeclare("direct_logs", BuiltinExchangeType.DIRECT);

        //向指定交换机发送消息,携带路由键关键词
        while(true){
            System.out.println("输入消息：");
            String messageInfo = new Scanner(System.in).nextLine();
            System.out.println("请输入路由键：");
            String routeKey = new Scanner(System.in).nextLine();

            //direct 类型交换机, basicPublish第二个参数是路由键。默认交换机的第二个参数是队列名
            channel.basicPublish("direct_logs", routeKey, null, messageInfo.getBytes());
        }
    }
}
