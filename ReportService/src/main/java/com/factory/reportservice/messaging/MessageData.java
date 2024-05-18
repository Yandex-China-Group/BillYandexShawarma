package com.factory.reportservice.messaging;


/**
 * {
 *      "type": "SpendReport",
 *      "data": {
 *          ...
 *      }
 * }
 * @param <T> Тип даты
 */
public interface MessageData<T> {
    T data();
    String type();
}
