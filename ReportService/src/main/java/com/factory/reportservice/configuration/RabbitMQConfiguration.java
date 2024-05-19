package com.factory.reportservice.configuration;

import com.factory.reportservice.messaging.listener.DefaultListener;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {
    @Value("${messaging.queue.name}")
    private String queueName;
    @Value("${messaging.topic.name}")
    private String topicName;
    @Value("${messaging.routing.key}")
    private String routingKey;

    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange(this.topicName);
    }

    @Bean
    Queue queue() {
        return new Queue(this.queueName, false);
    }

    @Bean
    Binding binding(TopicExchange topic, Queue queue) {
        return BindingBuilder.bind(queue).to(topic).with(this.routingKey);
    }

    @Bean
    SimpleMessageListenerContainer listener(ConnectionFactory conn, MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(conn);
        container.setQueueNames(queueName);
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean
    MessageListenerAdapter messageListenerAdapter(DefaultListener listener) {
        return new MessageListenerAdapter(listener);
    }
}
