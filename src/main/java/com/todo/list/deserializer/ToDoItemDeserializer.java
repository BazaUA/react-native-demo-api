package com.todo.list.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.todo.list.entities.ToDoItemEntity;

import java.io.IOException;
import java.util.Date;

public class ToDoItemDeserializer extends JsonDeserializer {
    @Override
    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        String value = node.get("value").textValue();
        boolean isDone = node.get("done").booleanValue();
        long longDate = node.get("date").longValue();
        Date utilDate = new Date(longDate);
        ToDoItemEntity item = new ToDoItemEntity();
        item.setName(value);
        item.setDone(isDone);
        item.setDate(utilDate);
        return item;
    }
}
