package api.auth.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address{

	@JsonProperty("zip")
	private String zip;

	@JsonProperty("street")
	private String street;

	@JsonProperty("houseNumber")
	private String houseNumber;

	@JsonProperty("apartmentNumber")
	private String apartmentNumber;

	public Address(String zip, String street, String houseNumber, String apartmentNumber) {
		this.zip = zip;
		this.street = street;
		this.houseNumber = houseNumber;
		this.apartmentNumber = apartmentNumber;
	}

	public String getZip(){
		return zip;
	}

	public String getStreet(){
		return street;
	}

	public String getHouseNumber(){
		return houseNumber;
	}

	public String getApartmentNumber(){
		return apartmentNumber;
	}
}