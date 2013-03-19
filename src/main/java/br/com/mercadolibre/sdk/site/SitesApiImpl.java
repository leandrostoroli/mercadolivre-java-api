package br.com.mercadolibre.sdk.site;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.mercadolibre.sdk.MercadoLivre;
import br.com.mercadolibre.sdk.utils.ImmediatePaymentSerializerDeserializerGson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.mercadolibre.sdk.MeliException;
import com.ning.http.client.Response;

public class SitesApiImpl implements SitesApi {
	
	private MercadoLivre mercadoLibre;
	
	private Gson gson;
	
	public SitesApiImpl(MercadoLivre mercadoLibre) {
		this.mercadoLibre = mercadoLibre;
		this.gson = new GsonBuilder()
			.registerTypeAdapter(ImmediatePayment.class, new ImmediatePaymentSerializerDeserializerGson())
			.registerTypeAdapter(SaleFeesMode.class, new SaleFeesModeSerializerDeserializerGson())
			.create();
		
	}

	@Override
	public List<SiteBasicInfo> getSites() {
		try {
			Response response = mercadoLibre.get("/sites");
			return gson.fromJson(response.getResponseBody(), new TypeToken<List<SiteBasicInfo>>(){}.getType());
		} catch (MeliException e) {
			e.printStackTrace();
			return new ArrayList<SiteBasicInfo>();
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
			return new ArrayList<SiteBasicInfo>();
		} catch (IOException e) {
			e.printStackTrace();
			return new ArrayList<SiteBasicInfo>();
		}
	}

	@Override
	public Site getSite(String siteId) {
		try {
			Response response = mercadoLibre.get("/sites/"+siteId);
			return gson.fromJson(response.getResponseBody(), Site.class);
		} catch (MeliException e) {
			e.printStackTrace();
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
