package br.com.mercadolibre.sdk.site;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class ListingExposures implements Serializable {

	private static final long serialVersionUID = -7504694767772384589L;
	
	private String id;
	
	private String name;
	
	@SerializedName("home_page")
	private boolean homePage;
	
	@SerializedName("category_home_page")
	private boolean categoryHomePage;
	
	@SerializedName("advertising_on_listing_page")
	private boolean advertisingOnListingPage;
	
	@SerializedName("priority_in_search")
	private Integer priorityInSearch;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isHomePage() {
		return homePage;
	}

	public void setHomePage(boolean homePage) {
		this.homePage = homePage;
	}

	public boolean isCategoryHomePage() {
		return categoryHomePage;
	}

	public void setCategoryHomePage(boolean categoryHomePage) {
		this.categoryHomePage = categoryHomePage;
	}

	public boolean isAdvertisingOnListingPage() {
		return advertisingOnListingPage;
	}

	public void setAdvertisingOnListingPage(boolean advertisingOnListingPage) {
		this.advertisingOnListingPage = advertisingOnListingPage;
	}

	public Integer getPriorityInSearch() {
		return priorityInSearch;
	}

	public void setPriorityInSearch(Integer priorityInSearch) {
		this.priorityInSearch = priorityInSearch;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (advertisingOnListingPage ? 1231 : 1237);
		result = prime * result + (categoryHomePage ? 1231 : 1237);
		result = prime * result + (homePage ? 1231 : 1237);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime
				* result
				+ ((priorityInSearch == null) ? 0 : priorityInSearch.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListingExposures other = (ListingExposures) obj;
		if (advertisingOnListingPage != other.advertisingOnListingPage)
			return false;
		if (categoryHomePage != other.categoryHomePage)
			return false;
		if (homePage != other.homePage)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (priorityInSearch == null) {
			if (other.priorityInSearch != null)
				return false;
		} else if (!priorityInSearch.equals(other.priorityInSearch))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ListingExposures [id=" + id + ", name=" + name + ", homePage="
				+ homePage + ", categoryHomePage=" + categoryHomePage
				+ ", advertisingOnListingPage=" + advertisingOnListingPage
				+ ", priorityInSearch=" + priorityInSearch + "]";
	}

}
