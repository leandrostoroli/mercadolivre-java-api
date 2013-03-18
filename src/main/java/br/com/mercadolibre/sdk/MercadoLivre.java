package br.com.mercadolibre.sdk;

import br.com.mercadolibre.sdk.site.SitesApi;
import br.com.mercadolibre.sdk.site.SitesApiImpl;

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

}
