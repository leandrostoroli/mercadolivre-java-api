package br.com.mercadolibre.sdk.category;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import br.com.mercadolibre.sdk.MercadoLivre;

public class CategoryApiTest {
	
	private MercadoLivre meli;
	
	private String categoryId;

	private Long clientId = 123456L;

	private String clientSecret = "123456";
	
	@Before
	public void before() {
		meli = spy(new MercadoLivre(clientId, clientSecret));
	}
	
	@Test
	public void shouldGetCategoryById() {
		categoryId = "MLB5672";
		
		Category categoryShouldBe = new Category();
		
		CategoryApi categoryApi = meli.getCategoryApi();
		Category category = categoryApi.getCategory(categoryId);
		assertThat(category, is(notNullValue()));
	}

}
