package com.pd;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan("com.pd.mapper")
public class RunPdAPP{

	public static void main(String[] args) {
		SpringApplication.run(RunPdAPP.class, args);
	}

	/**
	 * roy添加：
	 *
	 * 新建Queue实例，用来封装队列的参数
	 * Rabbitmq的自动配置类会自动发现 Queue 实例
	 * 根据其中的参数，连接服务器创建队列
	 * (该配置可以新建一个配置类配置也可以写在启动类)
	 */

	//import org.springframework.amqp.core.Queue; 别导错了
	@Bean
	public  Queue orderQueue(){
		//参数分别为(队列名,非持久队列,非独占,是否自动删除)
		return new Queue("orderQueue",true,false,false);
	}

}
