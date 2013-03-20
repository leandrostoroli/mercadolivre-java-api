package br.com.mercadolibre.sdk.site;

import java.util.List;

public interface SitesApi {

	List<SiteBasicInfo> getSites();

	Site getSite(String siteId);

	List<ListingType> getListingTypes(String siteId);

	List<ListingExposures> getListingExposures(String siteId);

}
