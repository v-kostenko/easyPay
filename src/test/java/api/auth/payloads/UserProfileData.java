package api.auth.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserProfileData{

	@JsonProperty("firstName")
	private String firstName;

	@JsonProperty("lastName")
	private String lastName;

	@JsonProperty("paymentMail")
	private boolean paymentMail;

	@JsonProperty("infoMail")
	private boolean infoMail;

	@JsonProperty("address")
	private Address address;

	@JsonProperty("walletPayment")
	private boolean walletPayment;

	@JsonProperty("location")
	private String location;

	@JsonProperty("locale")
	private String locale;

	@JsonProperty("email")
	private String email;

	@JsonProperty("vCardTopUp")
	private boolean vCardTopUp;

	public UserProfileData(String firstName, String lastName, boolean paymentMail, boolean infoMail, Address address, boolean walletPayment, String location, String locale, String email, boolean vCardTopUp) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.paymentMail = paymentMail;
		this.infoMail = infoMail;
		this.address = address;
		this.walletPayment = walletPayment;
		this.location = location;
		this.locale = locale;
		this.email = email;
		this.vCardTopUp = vCardTopUp;
	}

	public String getFirstName(){
		return firstName;
	}

	public String getLastName(){
		return lastName;
	}

	public boolean isPaymentMail(){
		return paymentMail;
	}

	public boolean isInfoMail(){
		return infoMail;
	}

	public Address getAddress(){
		return address;
	}

	public boolean isWalletPayment(){
		return walletPayment;
	}

	public String getLocation(){
		return location;
	}

	public String getLocale(){
		return locale;
	}

	public String getEmail(){
		return email;
	}

	public boolean isVCardTopUp(){
		return vCardTopUp;
	}
}