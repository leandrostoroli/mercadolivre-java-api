package br.com.mercadolibre.sdk.user;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

import br.com.mercadolibre.sdk.MercadoLivre;

public class UserApiTest {
	
	private MercadoLivre meli;
	
	private UserApi api;

	private Long clientId;

	private String clientSecret;
	
	private String userId;
	
	@Before
	public void before() {
		meli = spy(new MercadoLivre(clientId, clientSecret));
		api = meli.getUserApi();
	}
	
	@Test
	public void shouldGetUser() {
		User userShouldBe = new User();
		
		User user = api.getUser(userId);

		assertThat(user, is(notNullValue()));
		assertThat(userShouldBe, is(equalTo(user)));
	}

}
