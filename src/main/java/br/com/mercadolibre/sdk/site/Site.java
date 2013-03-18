package br.com.mercadolibre.sdk.site;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.mercadolibre.sdk.category.CategoryBasicInfo;
import br.com.mercadolibre.sdk.currency.Currency;
import br.com.mercadolibre.sdk.settings.Settings;

import com.google.gson.annotations.SerializedName;

public class Site implements Serializable {

	private static final long serialVersionUID = -935146499860835329L;
	
	private String id;
	
	private String name;
	
	@SerializedName("country_id")
	private String countryId;
	
	@SerializedName("sale_fees_mode")
	private SaleFeesMode saleFeesMode;
	
	@SerializedName("mercadopago_version")
	private Integer mercadoPagoVersion; 
	
	@SerializedName("default_currency_id")
	private String defaultCurrencyId;
	
	private List<Currency> currencies;
	
	@SerializedName("immediate_payment")
	private ImmediatePayment immediatePayment;
	
	@SerializedName("payment_method_ids")
	private List<String> paymentMethodIds;
	
	private List<CategoryBasicInfo> categories;
	
	private Settings settings;
	
	public Site() {
		currencies = new ArrayList<Currency>();
		paymentMethodIds = new ArrayList<String>();
		categories = new ArrayList<CategoryBasicInfo>();
	}

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

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public SaleFeesMode getSaleFeesMode() {
		return saleFeesMode;
	}

	public void setSaleFeesMode(SaleFeesMode saleFeesMode) {
		this.saleFeesMode = saleFeesMode;
	}

	public Integer getMercadoPagoVersion() {
		return mercadoPagoVersion;
	}

	public void setMercadoPagoVersion(Integer mercadoPagoVersion) {
		this.mercadoPagoVersion = mercadoPagoVersion;
	}

	public String getDefaultCurrencyId() {
		return defaultCurrencyId;
	}

	public void setDefaultCurrencyId(String defaultCurrencyId) {
		this.defaultCurrencyId = defaultCurrencyId;
	}

	public List<Currency> getCurrencies() {
		return currencies;
	}

	public void setCurrencies(List<Currency> currencies) {
		this.currencies = currencies;
	}

	public ImmediatePayment getImmediatePayment() {
		return immediatePayment;
	}

	public void setImmediatePayment(ImmediatePayment immediatePayment) {
		this.immediatePayment = immediatePayment;
	}

	public List<String> getPaymentMethodIds() {
		return paymentMethodIds;
	}

	public void setPaymentMethodIds(List<String> paymentMethodIds) {
		this.paymentMethodIds = paymentMethodIds;
	}

	public List<CategoryBasicInfo> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryBasicInfo> categories) {
		this.categories = categories;
	}

	public Settings getSettings() {
		return settings;
	}

	public void setSettings(Settings settings) {
		this.settings = settings;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((countryId == null) ? 0 : countryId.hashCode());
		result = prime
				* result
				+ ((defaultCurrencyId == null) ? 0 : defaultCurrencyId
						.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime
				* result
				+ ((immediatePayment == null) ? 0 : immediatePayment.hashCode());
		result = prime
				* result
				+ ((mercadoPagoVersion == null) ? 0 : mercadoPagoVersion
						.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((saleFeesMode == null) ? 0 : saleFeesMode.hashCode());
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
		Site other = (Site) obj;
		if (countryId == null) {
			if (other.countryId != null)
				return false;
		} else if (!countryId.equals(other.countryId))
			return false;
		if (defaultCurrencyId == null) {
			if (other.defaultCurrencyId != null)
				return false;
		} else if (!defaultCurrencyId.equals(other.defaultCurrencyId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (immediatePayment != other.immediatePayment)
			return false;
		if (mercadoPagoVersion == null) {
			if (other.mercadoPagoVersion != null)
				return false;
		} else if (!mercadoPagoVersion.equals(other.mercadoPagoVersion))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (saleFeesMode != other.saleFeesMode)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Site [id=" + id + ", name=" + name + ", countryId=" + countryId
				+ ", saleFeesMode=" + saleFeesMode + ", mercadoPagoVersion="
				+ mercadoPagoVersion + ", defaultCurrencyId="
				+ defaultCurrencyId + ", currencies=" + currencies
				+ ", immediatePayment=" + immediatePayment
				+ ", paymentMethodIds=" + paymentMethodIds + ", categories="
				+ categories + ", settings=" + settings + "]";
	}
	

}
