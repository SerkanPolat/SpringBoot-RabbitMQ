package com.sp.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfiguration {

    //Parametreler konfigurasyon dosyasindan aliniyor.
    @Value("${sp.rabbit.queue.name}")
    private String queueName;
    @Value("${sp.rabbit.routing.name}")
    private String routingName;
    @Value("${sp.rabbit.exchange.name}")
    private String exchangeName;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Bean
    public Queue queue(){
        return new Queue(queueName);
    }
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(exchangeName);
    }
    @Bean
    public Binding binding(final Queue queue, final DirectExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(routingName);
    }



}
