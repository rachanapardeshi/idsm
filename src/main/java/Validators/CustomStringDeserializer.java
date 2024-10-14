package Validators;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;

import java.io.IOException;

public class CustomStringDeserializer extends StdDeserializer<String> {
    private boolean trimStrings = true;
    private boolean emptyStringAsNull = true;

    public CustomStringDeserializer() {
        super(String.class);
    }

    @Override
    public String deserialize(JsonParser p, DeserializationContext ctx) throws IOException, JsonProcessingException {
        String result = StringDeserializer.instance.deserialize(p, ctx);

        if (trimStrings) {
            if (result != null)
                result = result.trim();
        }
        if (emptyStringAsNull) {
            if (result == null || result.equals(""))
                result = null;
        }
        return result;
    }
}
