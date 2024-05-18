package com.factory.reportservice.messaging.pulling;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainPullService implements RedisPullService<String> {
    private StringRedisTemplate redisTemplate;
    private final Queue<String> messages = new ConcurrentLinkedQueue<>();
    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    private long period = 500;
    private TimeUnit unit = TimeUnit.MILLISECONDS;

    @Value("${redis.listener.main}")
    private String topicMain;

    public MainPullService(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public String getMessage() {
        return messages.poll();
    }

    @Override
    public void startPolling(long period, TimeUnit unit) {
        this.period = period;
        this.unit = unit;
        this.executorService.scheduleAtFixedRate(this::polling, 0, this.period, this.unit);
    }

    private void polling() {
        this.redisTemplate.convertAndSend(this.topicMain, "OK");
    }
}
