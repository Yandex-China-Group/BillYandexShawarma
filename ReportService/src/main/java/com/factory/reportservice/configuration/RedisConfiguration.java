package com.factory.reportservice.configuration;

import com.factory.reportservice.messaging.receiver.MainReceiver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

@Configuration
public class RedisConfiguration {
    @Value("${redis.listener.main}")
    private String topicMain;

    @Bean
    MessageListenerAdapter listener() {
        return new MessageListenerAdapter(new MainReceiver());
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory rcf) {
        final RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(rcf);
        template.setValueSerializer(new GenericToStringSerializer<>(Object.class));
        return template;
    }
}
