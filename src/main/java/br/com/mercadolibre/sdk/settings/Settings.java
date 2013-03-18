package br.com.mercadolibre.sdk.settings;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Settings implements Serializable {

	private static final long serialVersionUID = 7707326564189890619L;
	
	@SerializedName("identification_types")
	private List<String> identificationTypes;
	
	@SerializedName("taxpayer_types")
	private List<String> taxPayerTypes;
	
	public Settings() {
		identificationTypes = new ArrayList<String>();
		taxPayerTypes = new ArrayList<String>();
	}

	public List<String> getIdentificationTypes() {
		return identificationTypes;
	}

	public void setIdentificationTypes(List<String> identificationTypes) {
		this.identificationTypes = identificationTypes;
	}

	public List<String> getTaxPayerTypes() {
		return taxPayerTypes;
	}

	public void setTaxPayerTypes(List<String> taxPayerTypes) {
		this.taxPayerTypes = taxPayerTypes;
	}

}
