package br.com.mercadolibre.sdk.category;

import java.io.IOException;

import br.com.mercadolibre.sdk.MercadoLivre;
import br.com.mercadolibre.sdk.settings.BuyingMode;
import br.com.mercadolibre.sdk.utils.EnumSerializerDeserializerGson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.mercadolibre.sdk.MeliException;
import com.ning.http.client.Response;

public class CategoryApiImpl implements CategoryApi {

	private MercadoLivre mercadoLivre;
	
	private Gson gson;

	public CategoryApiImpl(MercadoLivre mercadoLivre) {
		this.mercadoLivre = mercadoLivre;
		this.gson = new GsonBuilder()
			.registerTypeAdapter(BuyingMode.class, new EnumSerializerDeserializerGson<BuyingMode>())
			.create();
	}

	@Override
	public Category getCategory(String categoryId) {
		try {
			Response response = mercadoLivre.get("/categories/"+categoryId);
			return gson.fromJson(response.getResponseBody(), Category.class);
		} catch (MeliException e) {
			e.printStackTrace();
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
