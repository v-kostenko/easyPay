package api.auth.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CheckConfirmPhoneCode{

	@JsonProperty("code")
	private String code;

	@JsonProperty("phone")
	private String phone;

	public CheckConfirmPhoneCode(String phone, String code) {
		this.phone = phone;
		this.code = code;
	}

	public String getCode(){
		return code;
	}

	public String getPhone(){
		return phone;
	}
}