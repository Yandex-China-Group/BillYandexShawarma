package com.factory.reportservice.messaging;

import com.fasterxml.jackson.databind.JsonNode;

public record InputMessageData(JsonNode data, String type) implements MessageData<JsonNode> {
    @Override
    public JsonNode data() {
        return data;
    }

    @Override
    public String type() {
        return type;
    }
}
