package com.factory.reportservice.messaging.factory;

import com.factory.reportservice.messaging.MessageData;
import com.fasterxml.jackson.databind.JsonNode;

public interface MessageDataFactory {
    /**
     *
     * @param messageData
     * @return Тип в классе, в messageData#getType
     */
    Class<?> getDataFromMessageData(MessageData<JsonNode> messageData) throws ClassNotFoundException;
}
