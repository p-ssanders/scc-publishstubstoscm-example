package com.customer.app;

import com.customer.primaryentity.PrimaryEntityEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.net.URI;
import java.time.Instant;

public class EventPublisher {
    private final RabbitTemplate rabbitTemplate;

    public EventPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishEvent() {
        rabbitTemplate.convertAndSend(new PrimaryEntityEvent(Instant.now(), URI.create("https://example.com")));
    }
}
