package Validators;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;

import java.io.IOException;

/**
 * Case-insensitive deserialization of constants.
 */
public class DataTypeDeserializer extends StdDeserializer<DataType> {
    public DataTypeDeserializer() {
        super(DataType.class);
    }

    @Override
    public DataType deserialize(JsonParser p, DeserializationContext ctx) throws IOException, JsonProcessingException {
        String s = StringDeserializer.instance.deserialize(p, ctx);

        if (s == null || s.equals(""))
            s = null;

        return (s == null) ? null : DataType.valueOf(s.toUpperCase());
    }
}
