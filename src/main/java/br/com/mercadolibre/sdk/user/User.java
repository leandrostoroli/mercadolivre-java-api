package br.com.mercadolibre.sdk.user;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class User implements Serializable {

	private static final long serialVersionUID = 5014326528732689077L;
	
	private String id;
	
	@SerializedName("nickname")
	private String nickName;
	
	@SerializedName("registration_date")
	private Calendar registrationDate;
	
	@SerializedName("country_id")
	private String countryId;
	
	private AddressBasicInfo address;
	
	private UserType userType;
	
	private List<String> tags;
	
	private String logo;
	
	private Long points;
	
	@SerializedName("site_id")
	private String siteId;
	
	private String permalink;
	
	private SellerReputation sellerReputation;

}
