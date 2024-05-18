package com.factory.reportservice.messaging.runner;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQRunner implements CommandLineRunner {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Value("${messaging.routing.key}")
    private String routingKey;

    @Override
    public void run(String... args) throws Exception {
        new Thread(() -> {
            while (true) {
                rabbitTemplate.convertAndSend("finance", routingKey, "Hi");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
}
