package br.com.mercadolibre.sdk.user;

import java.io.IOException;

import br.com.mercadolibre.sdk.MercadoLivre;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.mercadolibre.sdk.MeliException;
import com.ning.http.client.Response;

public class UserApiImpl implements UserApi {
	
	private MercadoLivre mercadoLivre;
	
	private Gson gson;

	public UserApiImpl(MercadoLivre mercadoLivre) {
		this.mercadoLivre = mercadoLivre;
		this.gson = new Gson();
	}

	@Override
	public User getUser(String userId) {
		try {
			Response response = mercadoLivre.get("/users/"+userId);
			return gson.fromJson(response.getResponseBody(), User.class);
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
