package com.customer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.customer.app.EventPublisher;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProviderDrivenContractsDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderDrivenContractsDemoApplication.class, args);
    }

    @Bean
    FanoutExchange exchange() {
        return new FanoutExchange("provider-driven-contracts-demo-primaryentity-events");
    }

    @Bean
    Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return new Jackson2JsonMessageConverter(objectMapper);
    }

    @Bean
    EventPublisher eventPublisher(RabbitTemplate rabbitTemplate) {
        rabbitTemplate.setMessageConverter(jackson2JsonMessageConverter());
        rabbitTemplate.setExchange(exchange().getName());
        return new EventPublisher(rabbitTemplate);
    }
}
