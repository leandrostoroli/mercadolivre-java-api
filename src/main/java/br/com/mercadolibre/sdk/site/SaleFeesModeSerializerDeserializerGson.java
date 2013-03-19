package br.com.mercadolibre.sdk.site;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class SaleFeesModeSerializerDeserializerGson implements JsonSerializer<SaleFeesMode>, JsonDeserializer<SaleFeesMode> {

	@Override
	public SaleFeesMode deserialize(JsonElement elem, Type type,
			JsonDeserializationContext ctx) throws JsonParseException {
		return SaleFeesMode.valueOf(elem.getAsString().toUpperCase());
	}

	@Override
	public JsonElement serialize(SaleFeesMode sale, Type type,
			JsonSerializationContext ctx) {
		return ctx.serialize(sale.toString().toLowerCase());
	}

}
