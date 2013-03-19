package br.com.mercadolibre.sdk.settings;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.mercadolibre.sdk.category.CategoryBasicInfo;
import br.com.mercadolibre.sdk.currency.Currency;
import br.com.mercadolibre.sdk.site.ImmediatePayment;

import com.google.gson.annotations.SerializedName;

public class Settings implements Serializable {

	private static final long serialVersionUID = 7707326564189890619L;
	
	@SerializedName("identification_types")
	private List<String> identificationTypes;
	
	@SerializedName("taxpayer_types")
	private List<String> taxPayerTypes;
	
	@SerializedName("adult_content")
	private boolean adultContent;
	
	@SerializedName("buying_allowed")
	private boolean buyingAllowed;
	
	@SerializedName("buying_modes")
	private List<BuyingMode> buyingModes;
	
	@SerializedName("coverage_areas")
	private CoverageArea coverageArea;
	
	private List<Currency> currencies;
	
	@SerializedName("immediate_payment")
	private ImmediatePayment immediatePayment;
	
	@SerializedName("item_conditions")
	private List<ItemCondition> itemConditions;
	
	@SerializedName("items_reviews_allowed")
	private boolean itemsReviewAllowed;
	
	@SerializedName("listing_allowed")
	private boolean listingAllowed;
	
	@SerializedName("max_pictures_per_item")
	private Integer maxPicturesPerItem;
	
	@SerializedName("maximum_price")
	private BigDecimal maximumPrice;
	
	@SerializedName("minimum_price")
	private BigDecimal minimumPrice;
	
	@SerializedName("mirror_category")
	private CategoryBasicInfo mirrorCategory;
	
	private Price price;
	
	@SerializedName("rounded_address")
	private boolean roundedAddress;
	
	@SerializedName("seller_contact")
	private SellerContact sellerContact;
	
	@SerializedName("shipping_modes")
	private List<String> shippingModes;
	
	@SerializedName("shipping_options")
	private List<String> shippingOptions;
	
	@SerializedName("shipping_profile")
	private ShippingProfile shippingProfile;
	
	@SerializedName("show_contact_information")
	private boolean showContactInformation;
	
	@SerializedName("simple_shipping")
	private SimpleShipping simpleShipping;
	
	private Stock stock;
	
	private List<String> tags;
	
	@SerializedName("vip_subdomain")
	private String vipSubdomain;
	
	
	public Settings() {
		identificationTypes = new ArrayList<String>();
		taxPayerTypes = new ArrayList<String>();
		buyingAllowed = true;
		buyingModes = new ArrayList<BuyingMode>();
		currencies = new ArrayList<Currency>();
		itemConditions = new ArrayList<ItemCondition>();
		shippingModes = new ArrayList<String>();
		shippingOptions = new ArrayList<String>();
		tags = new ArrayList<String>();
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

	public boolean isAdultContent() {
		return adultContent;
	}

	public void setAdultContent(boolean adultContent) {
		this.adultContent = adultContent;
	}

	public boolean isBuyingAllowed() {
		return buyingAllowed;
	}

	public void setBuyingAllowed(boolean buyingAllowed) {
		this.buyingAllowed = buyingAllowed;
	}

	public List<BuyingMode> getBuyingModes() {
		return buyingModes;
	}

	public void setBuyingModes(List<BuyingMode> buyingModes) {
		this.buyingModes = buyingModes;
	}

	public CoverageArea getCoverageArea() {
		return coverageArea;
	}

	public void setCoverageArea(CoverageArea coverageArea) {
		this.coverageArea = coverageArea;
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

	public List<ItemCondition> getItemConditions() {
		return itemConditions;
	}

	public void setItemConditions(List<ItemCondition> itemConditions) {
		this.itemConditions = itemConditions;
	}

	public boolean isItemsReviewAllowed() {
		return itemsReviewAllowed;
	}

	public void setItemsReviewAllowed(boolean itemsReviewAllowed) {
		this.itemsReviewAllowed = itemsReviewAllowed;
	}

	public boolean isListingAllowed() {
		return listingAllowed;
	}

	public void setListingAllowed(boolean listingAllowed) {
		this.listingAllowed = listingAllowed;
	}

	public Integer getMaxPicturesPerItem() {
		return maxPicturesPerItem;
	}

	public void setMaxPicturesPerItem(Integer maxPicturesPerItem) {
		this.maxPicturesPerItem = maxPicturesPerItem;
	}

	public BigDecimal getMaximumPrice() {
		return maximumPrice;
	}

	public void setMaximumPrice(BigDecimal maximumPrice) {
		this.maximumPrice = maximumPrice;
	}

	public BigDecimal getMinimumPrice() {
		return minimumPrice;
	}

	public void setMinimumPrice(BigDecimal minimumPrice) {
		this.minimumPrice = minimumPrice;
	}

	public CategoryBasicInfo getMirrorCategory() {
		return mirrorCategory;
	}

	public void setMirrorCategory(CategoryBasicInfo mirrorCategory) {
		this.mirrorCategory = mirrorCategory;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public boolean isRoundedAddress() {
		return roundedAddress;
	}

	public void setRoundedAddress(boolean roundedAddress) {
		this.roundedAddress = roundedAddress;
	}

	public SellerContact getSellerContact() {
		return sellerContact;
	}

	public void setSellerContact(SellerContact sellerContact) {
		this.sellerContact = sellerContact;
	}

	public List<String> getShippingModes() {
		return shippingModes;
	}

	public void setShippingModes(List<String> shippingModes) {
		this.shippingModes = shippingModes;
	}

	public List<String> getShippingOptions() {
		return shippingOptions;
	}

	public void setShippingOptions(List<String> shippingOptions) {
		this.shippingOptions = shippingOptions;
	}

	public ShippingProfile getShippingProfile() {
		return shippingProfile;
	}

	public void setShippingProfile(ShippingProfile shippingProfile) {
		this.shippingProfile = shippingProfile;
	}

	public boolean isShowContactInformation() {
		return showContactInformation;
	}

	public void setShowContactInformation(boolean showContactInformation) {
		this.showContactInformation = showContactInformation;
	}

	public SimpleShipping getSimpleShipping() {
		return simpleShipping;
	}

	public void setSimpleShipping(SimpleShipping simpleShipping) {
		this.simpleShipping = simpleShipping;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public String getVipSubdomain() {
		return vipSubdomain;
	}

	public void setVipSubdomain(String vipSubdomain) {
		this.vipSubdomain = vipSubdomain;
	}

	@Override
	public String toString() {
		return "Settings [identificationTypes=" + identificationTypes
				+ ", taxPayerTypes=" + taxPayerTypes + ", adultContent="
				+ adultContent + ", buyingAllowed=" + buyingAllowed
				+ ", buyingModes=" + buyingModes + ", coverageArea="
				+ coverageArea + ", currencies=" + currencies
				+ ", immediatePayment=" + immediatePayment
				+ ", itemConditions=" + itemConditions
				+ ", itemsReviewAllowed=" + itemsReviewAllowed
				+ ", listingAllowed=" + listingAllowed
				+ ", maxPicturesPerItem=" + maxPicturesPerItem
				+ ", maximumPrice=" + maximumPrice + ", minimumPrice="
				+ minimumPrice + ", mirrorCategory=" + mirrorCategory
				+ ", price=" + price + ", roundedAddress=" + roundedAddress
				+ ", sellerContact=" + sellerContact + ", shippingModes="
				+ shippingModes + ", shippingOptions=" + shippingOptions
				+ ", shippingProfile=" + shippingProfile
				+ ", showContactInformation=" + showContactInformation
				+ ", simpleShipping=" + simpleShipping + ", stock=" + stock
				+ ", tags=" + tags + ", vipSubdomain=" + vipSubdomain + "]";
	}

}
