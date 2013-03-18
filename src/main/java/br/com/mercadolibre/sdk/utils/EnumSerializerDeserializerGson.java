package br.com.mercadolibre.sdk.utils;

import java.lang.reflect.Type;
import java.util.Arrays;

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
		return ((T) Enum.valueOf(type.getClass(), elem.getAsString().toUpperCase()));
	}
	
//	@Override
//	public JsonElement serialize(Enum<?> enumType, Type type,
//			JsonSerializationContext ctx) {
//		return ctx.serialize(enumType.toString().toLowerCase());
//	}
//
//	@Override
//	public <T extends Enum<T>> T deserialize(JsonElement elem, Type type,
//			JsonDeserializationContext ctx) throws JsonParseException {
//		return Enum.valueOf(type.getClass(), elem.getAsString().toUpperCase());
//	}

//	@Override
//	public ImmediatePayment deserialize(JsonElement elem, Type type,
//			JsonDeserializationContext ctx) throws JsonParseException {
//		return ImmediatePayment.valueOf(elem.getAsString().toUpperCase());
//	}
//
//	@Override
//	public JsonElement serialize(ImmediatePayment immediatePayment, Type type,
//			JsonSerializationContext ctx) {
//		return ctx.serialize(immediatePayment.toString().toLowerCase());
//	}

}
