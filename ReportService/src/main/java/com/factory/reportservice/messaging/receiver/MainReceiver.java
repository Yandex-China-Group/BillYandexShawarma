package com.factory.reportservice.messaging.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

public class MainReceiver implements MessageListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(MainReceiver.class);

    @Override
    public void onMessage(Message message, byte[] pattern) {
        LOGGER.info(message.toString());
    }
}
