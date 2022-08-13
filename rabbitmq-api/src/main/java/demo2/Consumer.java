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
        channel.queueDeclare("helloworld3", true, false, false, null);

        //回调对象(处理消息)
        DeliverCallback deliverCallback = (consumerTag, message) -> {
            String s = new String(message.getBody());
            System.out.println("收到：" + s);

            //处理消息，遍历字符串。遇到 . 字符就暂停一秒，来模拟耗时消息
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '.'){
                    try{
                       Thread.sleep(1000);
                    }catch(InterruptedException e){
                    }
                }
            }
            //手动发送回执：在message中的envelop中的_deliveryTag(交付标签)就是回执信息
            /*
                basicAck参数：
                    param1：回执信息
                    param2：是否只确认一条消息(一般只确认一条)

                光用手动确认还不能解决分发出现消息积压的情况。如果这条消息处理太耗时,迟迟不能返回确认信息,后面的消息还是会分发过来
                怎么办？  加Qos  - 函数：basicQos
             */
            channel.basicAck(message.getEnvelope().getDeliveryTag(),false);

            System.out.println("~~~~~消息处理完成~~~~~"); //注意输出，啥时候处理完才输出
        };
        CancelCallback cancelCallback = consumerTag -> {};

        // 每次只接收1条，处理完之前，不收下一条
        // 手动ack模式下才有效
        channel.basicQos(1);

        //消息消费(接收消息)
        /*
            自动确认产生的问题：rabbitmq消息队列的分发规则用的轮询,会出现当某一条消息在某一个消费者中处理耗时很长,当下一次分发到它时还没处理完,会积压,而其他的消费者该空闲就空闲着
            手动确认怎么解决：当队列发出一条消息时会在rabbitmq服务器缓存一条记录,里面包含一个回执信息,发到消费者的消息在被处理完成后并且正常返回ack反馈(回执信息),rabbitmq才会删除本地缓存的消息记录。
            发出去的消息没正常执行完服务器出故障或者网络故障怎么办？  rabbitmq会回滚消息到队列,当有新的空闲的消费者时再发送消息消费
            autoAck参数注释：
                 - true 自动确认
                 - false 手动确认 (自己还要加代码)
         */
        channel.basicConsume("helloworld3", false, deliverCallback, cancelCallback);
    }
}
