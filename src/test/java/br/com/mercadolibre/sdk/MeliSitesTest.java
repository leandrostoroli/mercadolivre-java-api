package br.com.mercadolibre.sdk;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import br.com.mercadolibre.sdk.site.SiteBasicInfo;
import br.com.mercadolibre.sdk.site.SitesApi;

public class MeliSitesTest {
	
	private MercadoLivre meli;
	private Long clientId;
	private String clientSecret;
	private String accessToken;
	private SitesApi sitesApi;
	
	@Before
	public void before() {
		meli = new MercadoLivre(clientId, clientSecret, accessToken);
		sitesApi = meli.getSiteApi();
	}
	
	@Test
	public void shouldGetSites() {
		List<SiteBasicInfo> sites = new ArrayList<SiteBasicInfo>();
		sites = sitesApi.getSites();
		assertThat(sites.size(), is(equalTo(10)));
	}
	
}
