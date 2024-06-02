package io.swagger.configuration;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;

public class StrictNumberDeserializer extends JsonDeserializer<Number> {
    @Override
    public Number deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonToken currentToken = p.getCurrentToken();
        if (currentToken != JsonToken.VALUE_NUMBER_INT && currentToken != JsonToken.VALUE_NUMBER_FLOAT) {
            throw ctxt.mappingException("Expected a number, found: " + currentToken);
        }

        // Lesen Sie den Wert als Zahl
        Number number = p.getNumberValue();
        return number;
    }
}
