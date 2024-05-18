package com.factory.reportservice.messaging.factory;

import com.factory.reportservice.messaging.MessageData;
import com.factory.reportservice.messaging.data.ReportRequest;
import com.fasterxml.jackson.databind.JsonNode;

public class MessageDataFactoryImpl implements MessageDataFactory {
    public static final String REPORT_REQUEST = ReportRequest.class.getSimpleName();

    @Override
    public Class<?> getDataFromMessageData(MessageData<JsonNode> messageData) throws ClassNotFoundException {
        if (messageData.type().equals(REPORT_REQUEST)) {
            return ReportRequest.class;
        }

        throw new ClassNotFoundException();
    }
}
