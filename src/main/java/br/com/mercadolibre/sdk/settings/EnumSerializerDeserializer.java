package br.com.mercadolibre.sdk.settings;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class EnumSerializerDeserializer<E extends Enum<?>> implements JsonSerializer<E>, 
	JsonDeserializer<E> {
	
	private E enumType;
	
	@SuppressWarnings("unchecked")
	public EnumSerializerDeserializer() {
		try {
			enumType = (E) Enum.class.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public E deserialize(JsonElement elem, Type type,
			JsonDeserializationContext ctx) throws JsonParseException {
		if (elem != null && !elem.getAsString().isEmpty()) {
			return (E) Enum.valueOf(enumType.getClass(), elem.getAsString().toUpperCase());
		}
		return null;
	}

	@Override
	public JsonElement serialize(E enumObj, Type type,
			JsonSerializationContext ctx) {
		return ctx.serialize(enumObj.toString().toLowerCase());
	}

//	@Override
//	public BuyingMode deserialize(JsonElement elem, Type type,
//			JsonDeserializationContext ctx) throws JsonParseException {
//		return BuyingMode.valueOf(elem.getAsString().toUpperCase());
//	}
//
//	@Override
//	public JsonElement serialize(BuyingMode mode, Type type,
//			JsonSerializationContext ctx) {
//		return ctx.serialize(mode.toString().toLowerCase());
//	}

}
