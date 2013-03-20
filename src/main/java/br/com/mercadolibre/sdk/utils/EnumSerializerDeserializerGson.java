package br.com.mercadolibre.sdk.utils;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class EnumSerializerDeserializerGson<T extends Enum<T>> implements JsonDeserializer<T>, 
	JsonSerializer<T> {
	
	@Override
	public JsonElement serialize(T enumType, Type type,
			JsonSerializationContext ctx) {
		return ctx.serialize(enumType.toString().toLowerCase());
	}

	@SuppressWarnings("unchecked")
	@Override
	public T deserialize(JsonElement elem, Type type,
			JsonDeserializationContext ctx) throws JsonParseException {
		for (Object enumConstant : ((Class<T>) type).getEnumConstants()) {
			if (((Enum<?>) enumConstant).name().equals(elem.getAsString().toUpperCase())) {
				return (T) enumConstant;
			}
		}
		return null;
	}
	
}
