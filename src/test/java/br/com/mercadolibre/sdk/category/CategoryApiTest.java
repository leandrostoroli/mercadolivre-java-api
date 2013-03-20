package br.com.mercadolibre.sdk.category;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.mercadolibre.sdk.MercadoLivre;

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
	public void before() {
		meli = spy(new MercadoLivre(clientId, clientSecret));
		categoryApi = meli.getCategoryApi();
		response = mock(Response.class);
	}
	
	@Test
	public void shouldGetCategoryById() {
		categoryId = "MLB5672";
		
		Category categoryShouldBe = new Category();
		
		try {
			Mockito.when(response.getResponseBody()).thenReturn("{'id':'MLB5672','name':'Acessórios para Veículos','permalink':'http://home.mercadolivre.com.br/veiculos-acessorios','total_items_in_this_category':1400691,'path_from_root':[{'id':'MLB5672','name':'Acessórios para Veículos'}],'children_categories':[{'id':'MLB6005','name':'Acessórios Náutica','total_items_in_this_category':6455},{'id':'MLB1747','name':'Acessórios de Carros','total_items_in_this_category':197279},{'id':'MLB1771','name':'Acessórios de Motos','total_items_in_this_category':161736},{'id':'MLB1776','name':'Acessórios e Peças Tuning','total_items_in_this_category':50417},{'id':'MLB8531','name':'GPS','total_items_in_this_category':18185},{'id':'MLB5802','name':'Outros','total_items_in_this_category':84972},{'id':'MLB6798','name':'Peças para 4x4','total_items_in_this_category':17454},{'id':'MLB22693','name':'Peças para Carros','total_items_in_this_category':666852},{'id':'MLB5768','name':'Restauração de Carros Antigos','total_items_in_this_category':99739},{'id':'MLB2238','name':'Rodas, Pneus e Calotas','total_items_in_this_category':42685},{'id':'MLB3381','name':'Som e Vídeo para Carro','total_items_in_this_category':54917}],'settings':{'adult_content':false,'buying_allowed':true,'buying_modes':['auction','buy_it_now'],'coverage_areas':'not_allowed','currencies':['BRL'],'immediate_payment':'optional','item_conditions':['new','not_specified','used'],'items_reviews_allowed':false,'listing_allowed':false,'max_pictures_per_item':6,'maximum_price':null,'minimum_price':null,'mirror_category':null,'price':'required','rounded_address':false,'seller_contact':'not_allowed','shipping_modes':['custom','me1','not_specified'],'shipping_options':['custom'],'shipping_profile':'optional','show_contact_information':false,'simple_shipping':'optional','stock':'required','tags':[],'vip_subdomain':'produto'}}");
			Mockito.when(meli.get("/categories/"+categoryId)).thenReturn(response);
		} catch (IOException e) {
			fail(e.getMessage());
		} catch (MeliException e) {
			fail(e.getMessage());
		}
		
		Category category = categoryApi.getCategory(categoryId);
		assertThat(category, is(notNullValue()));
	}

}
