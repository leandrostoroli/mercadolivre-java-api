package br.com.mercadolibre.sdk.site;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.mercadolibre.sdk.MercadoLivre;

import com.mercadolibre.sdk.MeliException;
import com.ning.http.client.Response;

public class SiteApiListingExposureTest {
	
	private MercadoLivre meli;
	
	private SitesApi api;
	
	private String siteId;

	private Long clientId;

	private String clientSecret;
	
	private Response response;
	
	@Before
	public void before() throws MeliException {
		siteId = "MLB";
		meli = spy(new MercadoLivre(clientId, clientSecret));
		api = meli.getSiteApi();
		response = mock(Response.class);
		when(meli.get("/sites/"+siteId+"/listing_exposures")).thenReturn(response);
	}
	
	@Test
	public void shouldGetListingExposures() {
		ListingExposures listingExposure = new ListingExposures();
		listingExposure.setId("lowest");
		listingExposure.setName("Ultima");
		listingExposure.setHomePage(false);
		listingExposure.setCategoryHomePage(false);
		listingExposure.setAdvertisingOnListingPage(true);
		listingExposure.setPriorityInSearch(4);
		
		try {
			when(response.getResponseBody()).thenReturn("[{'id':'lowest','name':'Ultima','home_page':false,'category_home_page':false,'advertising_on_listing_page':true,'priority_in_search':4},{'id':'low','name':'Inferior','home_page':false,'category_home_page':false,'advertising_on_listing_page':false,'priority_in_search':3},{'id':'mid','name':'Intermediária','home_page':false,'category_home_page':true,'advertising_on_listing_page':false,'priority_in_search':2},{'id':'high','name':'Alta','home_page':false,'category_home_page':true,'advertising_on_listing_page':false,'priority_in_search':1},{'id':'highest','name':'Superior','home_page':true,'category_home_page':true,'advertising_on_listing_page':false,'priority_in_search':0}]");
		} catch (IOException e) {
			fail(e.getMessage());
		}
		
		List<ListingExposures> listingExposures = api.getListingExposures(siteId);
		assertThat(listingExposures.size(), is(equalTo(5)));
		assertThat(listingExposures, hasItem(listingExposure));
	}
	
	@Test
	public void shouldGetListingExposuresEmpty() {
		try {
			when(response.getResponseBody()).thenReturn("");
		} catch (IOException e) {
			fail(e.getMessage());
		}
		
		List<ListingExposures> listingExposures = api.getListingExposures(siteId);
		assertThat(listingExposures.size(), is(equalTo(0)));
	}

}
