package api.easyPay_Auth.pojo.check;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiConfirmCode{

	@JsonProperty("code")
	private String code;

	@JsonProperty("phone")
	private String phone;

	public ApiConfirmCode(){

	}

	public ApiConfirmCode(String code, String phone) {
		this.code = code;
		this.phone = phone;
	}

	public String getCode(){
		return code;
	}

	public String getPhone(){
		return phone;
	}
}