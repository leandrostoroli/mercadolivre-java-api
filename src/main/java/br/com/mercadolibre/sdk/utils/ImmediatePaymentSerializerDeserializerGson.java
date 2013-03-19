package br.com.mercadolibre.sdk.utils;

import java.lang.reflect.Type;

import br.com.mercadolibre.sdk.site.ImmediatePayment;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class ImmediatePaymentSerializerDeserializerGson implements JsonDeserializer<ImmediatePayment>, 
	JsonSerializer<ImmediatePayment> {

	@Override
	public ImmediatePayment deserialize(JsonElement elem, Type type,
			JsonDeserializationContext ctx) throws JsonParseException {
		return ImmediatePayment.valueOf(elem.getAsString().toUpperCase());
	}

	@Override
	public JsonElement serialize(ImmediatePayment immediatePayment, Type type,
			JsonSerializationContext ctx) {
		return ctx.serialize(immediatePayment.toString().toLowerCase());
	}

}
