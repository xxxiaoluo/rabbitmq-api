package demo3;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * 发布订阅模式：消费者向fanout交换机发送消息，再向交换机绑定的队列所一一对应的消费者发送消息。以实现消息群发的效果
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

        //创建 fanout 交换机    起名叫 Logs
//        channel.exchangeDeclare("Logs", "fanout"); //和下面一样效果
        channel.exchangeDeclare("Logs", BuiltinExchangeType.FANOUT);

        //循环数据消息，并发送
        while(true){
            System.out.println("输入消息：");
            String s = new Scanner(System.in).nextLine();
            /*
                basicPublish参数注释：
                    param1: 交换机(不同交换机作用不同),空串是默认的一个交换机 作用：消息是通过交换机发送到队列的
                    param3: 消息的属性数据 没有其他属性就null值
             */
            channel.basicPublish("Logs", "", null, s.getBytes()); //给fanout交换机发送消息就无效了
        }
    }
}