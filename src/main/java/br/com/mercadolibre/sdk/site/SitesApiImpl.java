package br.com.mercadolibre.sdk.site;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.mercadolibre.sdk.MercadoLivre;
import br.com.mercadolibre.sdk.utils.EnumSerializerDeserializerGson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.mercadolibre.sdk.MeliException;
import com.ning.http.client.Response;

public class SitesApiImpl implements SitesApi {
	
	private MercadoLivre mercadoLivre;
	
	private Gson gson;
	
	public SitesApiImpl(MercadoLivre mercadoLivre) {
		this.mercadoLivre = mercadoLivre;
		this.gson = new GsonBuilder()
			.registerTypeAdapter(ImmediatePayment.class, new EnumSerializerDeserializerGson<ImmediatePayment>())		
			.registerTypeAdapter(SaleFeesMode.class, new EnumSerializerDeserializerGson<SaleFeesMode>())
			.create();
	}

	@Override
	public List<SiteBasicInfo> getSites() {
		try {
			Response response = mercadoLivre.get("/sites");
			List<SiteBasicInfo> sites = gson.fromJson(response.getResponseBody(), new TypeToken<List<SiteBasicInfo>>(){}.getType());
			return (sites != null)? sites : new ArrayList<SiteBasicInfo>(); 
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
			Response response = mercadoLivre.get("/sites/"+siteId);
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
