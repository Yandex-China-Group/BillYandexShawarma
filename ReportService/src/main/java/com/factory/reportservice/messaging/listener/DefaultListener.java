package com.factory.reportservice.messaging.listener;

import com.factory.reportservice.controller.dispatcher.VisitorDispatcher;
import com.factory.reportservice.messaging.InputMessageData;
import com.factory.reportservice.messaging.factory.MessageDataFactory;
import com.factory.reportservice.messaging.factory.MessageDataFactoryImpl;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class DefaultListener implements MessageListener {
    private final VisitorDispatcher visitorDispatcher;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public DefaultListener(VisitorDispatcher visitorDispatcher) {
        this.visitorDispatcher = visitorDispatcher;
    }

    @PostConstruct
    void init() {
        this.objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
        this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Override
    public void onMessage(Message message) {
        try {
            InputMessageData inputMessage = this.objectMapper.readValue(message.getBody(), InputMessageData.class);
            MessageDataFactory dataFactory = new MessageDataFactoryImpl();
            Class<?> type = dataFactory.getDataFromMessageData(inputMessage);
            Object dataClass = this.objectMapper.readValues(inputMessage.data().traverse(), type);
            visitorDispatcher.dispatch(type, dataClass);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Неизвестный тип объекта (структурно)", e);
        }
    }
}
