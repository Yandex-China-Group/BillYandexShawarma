package com.factory.reportservice.messaging.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class DefaultListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        System.out.println(message);
    }
}
