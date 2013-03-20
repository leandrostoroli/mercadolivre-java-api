package br.com.mercadolibre.sdk.site;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.mercadolibre.sdk.MercadoLivre;

import com.mercadolibre.sdk.MeliException;
import com.ning.http.client.FluentStringsMap;
import com.ning.http.client.Response;

public class SiteApiListingTypeTest {
	
	private SitesApi api;
	
	private MercadoLivre meli;

	private Long clientId;

	private String clientSecret;

	private String siteId;
	
	private Response response;
	
	@Before
	public void before() throws MeliException {
		siteId = "MLB";
		meli = spy(new MercadoLivre(clientId, clientSecret));
		api = meli.getSiteApi();
		response = mock(Response.class);
		FluentStringsMap params = new FluentStringsMap();
		params.add("price", "0");
		when(meli.get("/sites/"+siteId+"/listing_prices", params)).thenReturn(response);
	}
	
	@Test
	public void shouldGetListingTypeBySite() {
		ListingType listingTypeShouldBe = new ListingType();
		listingTypeShouldBe.setId("gold_premium");
		listingTypeShouldBe.setName("Diamante");
		listingTypeShouldBe.setExposure("highest");
		listingTypeShouldBe.setRequirePicture(true);
		listingTypeShouldBe.setCurrencyId("BRL");
		listingTypeShouldBe.setListingFeeAmount(new BigDecimal(150.00));
		listingTypeShouldBe.setSaleFeeAmount(new BigDecimal(1.00));
		listingTypeShouldBe.setFreeRelist(false);
		
		try {
			when(response.getResponseBody()).thenReturn("[{'listing_type_id':'gold_premium','listing_type_name':'Diamante','listing_exposure':'highest','requires_picture':true,'currency_id':'BRL','listing_fee_amount':150,'sale_fee_amount':1,'free_relist':false},{'listing_type_id':'gold','listing_type_name':'Ouro','listing_exposure':'high','requires_picture':true,'currency_id':'BRL','listing_fee_amount':35,'sale_fee_amount':1,'free_relist':false},{'listing_type_id':'silver','listing_type_name':'Prata','listing_exposure':'mid','requires_picture':false,'currency_id':'BRL','listing_fee_amount':1,'sale_fee_amount':1,'free_relist':false},{'listing_type_id':'bronze','listing_type_name':'Bronze','listing_exposure':'low','requires_picture':false,'currency_id':'BRL','listing_fee_amount':0,'sale_fee_amount':1,'free_relist':false},{'listing_type_id':'free','listing_type_name':'Grátis','listing_exposure':'lowest','requires_picture':false,'currency_id':'BRL','listing_fee_amount':0,'sale_fee_amount':0,'free_relist':false}]");
		} catch (IOException e) {
			fail(e.getMessage());
		}
		
		List<ListingType> listingTypes =  api.getListingTypes(siteId);
		
		assertThat(listingTypes.size(), is(equalTo(5)));
		assertThat(listingTypes, hasItem(listingTypeShouldBe));
	}
	
	@Test
	public void shouldGetEmptyList() {
		try {
			when(response.getResponseBody()).thenReturn("");
		} catch (IOException e) {
			fail(e.getMessage());
		}
		
		List<ListingType> listingTypes =  api.getListingTypes(siteId);
		assertThat(listingTypes.size(), is(equalTo(0)));
	}

}
