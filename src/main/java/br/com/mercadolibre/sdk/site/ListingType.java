package br.com.mercadolibre.sdk.site;

import java.io.Serializable;
import java.math.BigDecimal;

import com.google.gson.annotations.SerializedName;

public class ListingType implements Serializable {

	private static final long serialVersionUID = 694336580881134133L;
	
	@SerializedName("listing_type_id")
	private String id;
	
	@SerializedName("listing_type_name")
	private String name;
	
	@SerializedName("listing_exposure")
	private String exposure;
	
	@SerializedName("requires_picture")
	private boolean requirePicture;
	
	@SerializedName("currency_id")
	private String  currencyId;
	
	@SerializedName("listing_fee_amount")
	private BigDecimal listingFeeAmount;
	
	@SerializedName("sale_fee_amount")
	private BigDecimal saleFeeAmount;
	
	@SerializedName("free_relist")
	private boolean freeRelist;

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

	public String getExposure() {
		return exposure;
	}

	public void setExposure(String exposure) {
		this.exposure = exposure;
	}

	public boolean isRequirePicture() {
		return requirePicture;
	}

	public void setRequirePicture(boolean requirePicture) {
		this.requirePicture = requirePicture;
	}

	public String getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}

	public BigDecimal getListingFeeAmount() {
		return listingFeeAmount;
	}

	public void setListingFeeAmount(BigDecimal listingFeeAmount) {
		this.listingFeeAmount = listingFeeAmount;
	}

	public BigDecimal getSaleFeeAmount() {
		return saleFeeAmount;
	}

	public void setSaleFeeAmount(BigDecimal saleFeeAmount) {
		this.saleFeeAmount = saleFeeAmount;
	}

	public boolean isFreeRelist() {
		return freeRelist;
	}

	public void setFreeRelist(boolean freeRelist) {
		this.freeRelist = freeRelist;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((currencyId == null) ? 0 : currencyId.hashCode());
		result = prime * result
				+ ((exposure == null) ? 0 : exposure.hashCode());
		result = prime * result + (freeRelist ? 1231 : 1237);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime
				* result
				+ ((listingFeeAmount == null) ? 0 : listingFeeAmount.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (requirePicture ? 1231 : 1237);
		result = prime * result
				+ ((saleFeeAmount == null) ? 0 : saleFeeAmount.hashCode());
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
		ListingType other = (ListingType) obj;
		if (currencyId == null) {
			if (other.currencyId != null)
				return false;
		} else if (!currencyId.equals(other.currencyId))
			return false;
		if (exposure == null) {
			if (other.exposure != null)
				return false;
		} else if (!exposure.equals(other.exposure))
			return false;
		if (freeRelist != other.freeRelist)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (listingFeeAmount == null) {
			if (other.listingFeeAmount != null)
				return false;
		} else if (!listingFeeAmount.equals(other.listingFeeAmount))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (requirePicture != other.requirePicture)
			return false;
		if (saleFeeAmount == null) {
			if (other.saleFeeAmount != null)
				return false;
		} else if (!saleFeeAmount.equals(other.saleFeeAmount))
			return false;
		return true;
	}

}
