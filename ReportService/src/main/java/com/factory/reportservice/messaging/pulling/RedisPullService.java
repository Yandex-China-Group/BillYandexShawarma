package com.factory.reportservice.messaging.pulling;

import java.util.concurrent.TimeUnit;

public interface RedisPullService<T> {
    T getMessage();
    void startPolling(long period, TimeUnit unit);
}
