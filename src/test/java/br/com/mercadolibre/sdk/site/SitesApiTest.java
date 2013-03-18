package br.com.mercadolibre.sdk.site;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.mercadolibre.sdk.MercadoLivre;
import br.com.mercadolibre.sdk.category.CategoryBasicInfo;
import br.com.mercadolibre.sdk.currency.Currency;
import br.com.mercadolibre.sdk.settings.Settings;

import com.mercadolibre.sdk.MeliException;
import com.ning.http.client.Response;

public class SitesApiTest {

	private SitesApi api;
	
	private MercadoLivre meli;

	private String clientSecret = "JCR0M0qqcEOCgOHIAUVxJ5vZsaoGDMFN";

	private Long clientId = 1094307892167423L;
	
	private Response response;

	private String siteId;
	
	@Before
	public void before() {
		meli = Mockito.spy(new MercadoLivre(clientId, clientSecret));
		api = meli.getSiteApi();
		response = Mockito.mock(Response.class);
	}
	
	@Test
	public void shouldGetSites() {
		SiteBasicInfo site = new SiteBasicInfo("MLB", "Brasil");
		
		try {
			Mockito.when(response.getResponseBody()).thenReturn("[{\"id\": \"MLB\",\"name\": \"Brasil\"}]");
			Mockito.when(meli.get("/sites")).thenReturn(response);
		} catch (IOException e) {
			fail(e.getMessage());
		} catch (MeliException e) {
			fail(e.getMessage());
		}
		
		List<SiteBasicInfo> sites = api.getSites();
		assertThat(sites.size(), is(equalTo(1)));
		assertThat(sites.get(0), is(equalTo(site)));
	}
	
	@Test
	public void shouldGetSiteFullInfoById() {
		siteId = "MLB";
		
		Site siteShouldBe = new Site();
		siteShouldBe.setId("MLB");
		siteShouldBe.setName("Brasil");
		siteShouldBe.setCountryId("BR");
		siteShouldBe.setSaleFeesMode(SaleFeesMode.NOT_FREE);
		siteShouldBe.setMercadoPagoVersion(3);
		siteShouldBe.setDefaultCurrencyId("BRL");
		siteShouldBe.setCurrencies(Arrays.asList(new Currency("BRL", "R$")));
		siteShouldBe.setImmediatePayment(ImmediatePayment.OPTIONAL);
		siteShouldBe.setPaymentMethodIds(Arrays.asList("MLBMP","MLBWC","MLBMO","MLBBC","MLBCC","MLBDE","MLBCD","MLBOU"));
		siteShouldBe.setCategories(Arrays.asList(new CategoryBasicInfo("MLB5672", "Acessórios para Veículos")));
		Settings settings = new Settings();
		settings.setIdentificationTypes(Arrays.asList("CPF", "CNPJ"));
		siteShouldBe.setSettings(settings);
		
		try {
			Mockito.when(response.getResponseBody()).thenReturn("{'id': 'MLB', 'name': 'Brasil', 'country_id': 'BR', 'sale_fees_mode': 'not_free', 'mercadopago_version': 3, 'default_currency_id': 'BRL', 'currencies':  [{'id': 'BRL', 'symbol': 'R$' } ], 'immediate_payment': 'optional', 'payment_method_ids':  ['MLBMP', 'MLBWC', 'MLBMO', 'MLBBC', 'MLBCC', 'MLBDE', 'MLBCD', 'MLBOU'], 'categories':  [{'id': 'MLB5672', 'name': 'Acessórios para Veículos' } ], 'settings':  {'identification_types':  ['CPF', 'CNPJ'], 'taxpayer_types': [] } }");
			Mockito.when(meli.get("/sites/"+siteId)).thenReturn(response);
		} catch (IOException e) {
			fail(e.getMessage());
		} catch (MeliException e) {
			fail(e.getMessage());
		}
		
		Site site = api.getSite(siteId);
		assertThat(siteShouldBe, is(equalTo(site)));
	}
	
}
