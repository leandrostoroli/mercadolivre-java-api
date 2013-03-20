package br.com.mercadolibre.sdk.category;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.mercadolibre.sdk.MercadoLivre;
import br.com.mercadolibre.sdk.settings.BuyingMode;
import br.com.mercadolibre.sdk.settings.CoverageArea;
import br.com.mercadolibre.sdk.settings.ItemCondition;
import br.com.mercadolibre.sdk.settings.Price;
import br.com.mercadolibre.sdk.settings.SellerContact;
import br.com.mercadolibre.sdk.settings.Settings;
import br.com.mercadolibre.sdk.settings.ShippingProfile;
import br.com.mercadolibre.sdk.settings.SimpleShipping;
import br.com.mercadolibre.sdk.settings.Stock;
import br.com.mercadolibre.sdk.site.ImmediatePayment;

import com.mercadolibre.sdk.MeliException;
import com.ning.http.client.Response;

public class CategoryApiTest {
	
	private MercadoLivre meli;
	
	private String categoryId;

	private Long clientId = 123456L;

	private String clientSecret = "123456";

	private CategoryApi categoryApi;

	private Response response;
	
	@Before
	public void before() throws MeliException {
		categoryId = "MLB5672";
		meli = spy(new MercadoLivre(clientId, clientSecret));
		categoryApi = meli.getCategoryApi();
		response = mock(Response.class);
		Mockito.when(meli.get("/categories/"+categoryId)).thenReturn(response);
	}
	
	@Test
	public void shouldGetCategoryById() {
		Category categoryShouldBe = new Category();
		categoryShouldBe.setId(categoryId);
		categoryShouldBe.setName("Acessorios para Veiculos");
		categoryShouldBe.setPermalink("http://home.mercadolivre.com.br/veiculos-acessorios");
		categoryShouldBe.setTotalItemsInThisCategory(1400691L);
		List<CategoryBasicInfo> rootList = Arrays.asList(
				new CategoryBasicInfo("MLB5672", "Acessorios para Veiculos"));
		categoryShouldBe.setRoot(rootList);
		List<CategoryChildrenBasicInfo> childrenCategoriesList = Arrays.asList(
				new CategoryChildrenBasicInfo("MLB6005", "Acessorios Nautica", 6455L));
		categoryShouldBe.setChildrenCategories(childrenCategoriesList);
		Settings settings = new Settings();
		settings.setAdultContent(false);
		settings.setBuyingAllowed(true);
		settings.setBuyingModes(Arrays.asList(BuyingMode.AUCTION, BuyingMode.BUY_IT_NOW));
		settings.setCoverageArea(CoverageArea.NOT_ALLOWED);
		settings.setCurrencies(Arrays.asList("BRL"));
		settings.setImmediatePayment(ImmediatePayment.OPTIONAL);
		settings.setItemConditions(Arrays.asList(ItemCondition.NEW, ItemCondition.NOT_SPECIFIED, ItemCondition.USED));
		settings.setItemsReviewAllowed(false);
		settings.setListingAllowed(false);
		settings.setMaxPicturesPerItem(6);
		settings.setPrice(Price.REQUIRED);
		settings.setRoundedAddress(false);
		settings.setSellerContact(SellerContact.NOT_ALLOWED);
		settings.setShippingModes(Arrays.asList("custom", "me1", "not_specified"));
		settings.setShippingOptions(Arrays.asList("custom"));
		settings.setShippingProfile(ShippingProfile.OPTIONAL);
		settings.setShowContactInformation(false);
		settings.setSimpleShipping(SimpleShipping.OPTIONAL);
		settings.setStock(Stock.REQUIRED);
		settings.setVipSubdomain("produto");
		categoryShouldBe.setSettings(settings);
		
		try {
			Mockito.when(response.getResponseBody()).thenReturn("{\"id\":\"MLB5672\",\"name\":\"Acessorios para Veiculos\",\"permalink\":\"http://home.mercadolivre.com.br/veiculos-acessorios\",\"total_items_in_this_category\":1400691,\"path_from_root\":[{\"id\":\"MLB5672\",\"name\":\"Acessorios para Veiculos\"}],\"children_categories\":[{\"id\":\"MLB6005\",\"name\":\"Acessorios Nautica\",\"total_items_in_this_category\":6455},{\"id\":\"MLB1747\",\"name\":\"Acessorios de Carros\",\"total_items_in_this_category\":197279},{\"id\":\"MLB1771\",\"name\":\"Acessorios de Motos\",\"total_items_in_this_category\":161736},{\"id\":\"MLB1776\",\"name\":\"Acessorios e Pecas Tuning\",\"total_items_in_this_category\":50417},{\"id\":\"MLB8531\",\"name\":\"GPS\",\"total_items_in_this_category\":18185},{\"id\":\"MLB5802\",\"name\":\"Outros\",\"total_items_in_this_category\":84972},{\"id\":\"MLB6798\",\"name\":\"Pecas para 4x4\",\"total_items_in_this_category\":17454},{\"id\":\"MLB22693\",\"name\":\"Pecas para Carros\",\"total_items_in_this_category\":666852},{\"id\":\"MLB5768\",\"name\":\"Restauracao de Carros Antigos\",\"total_items_in_this_category\":99739},{\"id\":\"MLB2238\",\"name\":\"Rodas, Pneus e Calotas\",\"total_items_in_this_category\":42685},{\"id\":\"MLB3381\",\"name\":\"Som e V�deo para Carro\",\"total_items_in_this_category\":54917}],\"settings\":{\"adult_content\":false,\"buying_allowed\":true,\"buying_modes\":[\"auction\",\"buy_it_now\"],\"coverage_areas\":\"not_allowed\",\"currencies\":[\"BRL\"],\"immediate_payment\":\"optional\",\"item_conditions\":[\"new\",\"not_specified\",\"used\"],\"items_reviews_allowed\":false,\"listing_allowed\":false,\"max_pictures_per_item\":6,\"maximum_price\":null,\"minimum_price\":null,\"mirror_category\":null,\"price\":\"required\",\"rounded_address\":false,\"seller_contact\":\"not_allowed\",\"shipping_modes\":[\"custom\",\"me1\",\"not_specified\"],\"shipping_options\":[\"custom\"],\"shipping_profile\":\"optional\",\"show_contact_information\":false,\"simple_shipping\":\"optional\",\"stock\":\"required\",\"tags\":[],\"vip_subdomain\":\"produto\"}}");
		} catch (IOException e) {
			fail(e.getMessage());
		}
		
		Category category = categoryApi.getCategory(categoryId);
		assertThat(category, is(notNullValue()));
		assertThat(category.getChildrenCategories(), hasItem(categoryShouldBe.getChildrenCategories().get(0)));
		assertThat(category, is(equalTo(categoryShouldBe)));
	}

}
