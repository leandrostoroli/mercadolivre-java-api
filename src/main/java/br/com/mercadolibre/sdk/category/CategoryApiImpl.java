package br.com.mercadolibre.sdk.category;

import br.com.mercadolibre.sdk.MercadoLivre;
import br.com.mercadolibre.sdk.settings.BuyingMode;
import br.com.mercadolibre.sdk.settings.EnumSerializerDeserializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mercadolibre.sdk.MeliException;
import com.ning.http.client.Response;

public class CategoryApiImpl implements CategoryApi {

	private MercadoLivre mercadoLivre;
	
	private Gson gson;

	public CategoryApiImpl(MercadoLivre mercadoLivre) {
		this.mercadoLivre = mercadoLivre;
//		this.gson = new GsonBuilder()
//			.registerTypeAdapter(BuyingMode.class, new BuyingModeSerializerDeserializer())
//			.create
	}

	@Override
	public Category getCategory(String categoryId) {
		try {
			Response response = mercadoLivre.get("categories/"+categoryId);
			
		} catch (MeliException e) {
			e.printStackTrace();
		}
		return null;
	}

}
