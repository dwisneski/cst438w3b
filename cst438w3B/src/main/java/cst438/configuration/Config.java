package cst438.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cst438.listeners.W3Blistener;



@Configuration
public class Config {
	
	@Value("${queueName}")
	private String queueName;

    @Bean
    public Queue queue() {
        return new Queue(queueName);
    }
    
    @Bean
    public W3Blistener receiver() {
        return new W3Blistener();
    }
}