package demo1;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 简单模式：只有一个消费者 交换机使用默认的  AMQP Default
 */
@Slf4j
public class Producer {
    public static void main(String[] args) throws IOException, TimeoutException {
        //连接
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.64.100"); //我的Linux的ip
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("admin"); //Linux上部署的rabbitmq管理界面的账号
        connectionFactory.setPassword("admin");

        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel(); //通信通道

        //在服务器上创建队列
        channel.queueDeclare("helloworld", false, false, false, null);

        //向队列发消息
        channel.basicPublish("","helloworld",null,"水月通禅寂，鱼龙听梵声。".getBytes());
        log.info("消息发送了！！");
    }
}
