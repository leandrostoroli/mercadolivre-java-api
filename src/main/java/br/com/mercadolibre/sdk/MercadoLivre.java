package br.com.mercadolibre.sdk;

import br.com.mercadolibre.sdk.category.CategoryApi;
import br.com.mercadolibre.sdk.category.CategoryApiImpl;
import br.com.mercadolibre.sdk.site.SitesApi;
import br.com.mercadolibre.sdk.site.SitesApiImpl;
import br.com.mercadolibre.sdk.user.UserApi;
import br.com.mercadolibre.sdk.user.UserApiImpl;

import com.mercadolibre.sdk.Meli;

public class MercadoLivre extends Meli {

	public MercadoLivre(Long clientId, String clientSecret, String accessToken) {
		super(clientId, clientSecret, accessToken);
	}

	public MercadoLivre(Long clientId, String clientSecret) {
		super(clientId, clientSecret);
	}

	public SitesApi getSiteApi() {
		return new SitesApiImpl(this);
	}

	public CategoryApi getCategoryApi() {
		return new CategoryApiImpl(this);
	}

	public UserApi getUserApi() {
		return new UserApiImpl(this);
	}

}
