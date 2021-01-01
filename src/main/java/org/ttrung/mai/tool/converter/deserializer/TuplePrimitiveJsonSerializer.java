package org.ttrung.mai.tool.converter.deserializer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.ttrung.mai.tool.model.TupleKeyValue;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class TuplePrimitiveJsonSerializer extends JsonSerializer<TupleKeyValue<?, ?>> {

	@Override
	public void serialize(TupleKeyValue<?, ?> value, JsonGenerator gen, SerializerProvider serializers)
			throws IOException {
		Map<String, String> pojo = new HashMap<String, String>();
		pojo.put("key", value.getKey().toString());
		pojo.put("value", value.getValue().toString());
		gen.writeObject(pojo);
	}

}
