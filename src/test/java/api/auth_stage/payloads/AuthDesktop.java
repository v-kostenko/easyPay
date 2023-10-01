package api.auth_stage.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthDesktop {

	@JsonProperty("password")
	private String password;

	@JsonProperty("phone")
	private String phone;

	public AuthDesktop() {
	}

	public AuthDesktop(String phone, String password) {
		this.password = password;
		this.phone = phone;
	}

	public String getPassword(){
		return password;
	}

	public String getPhone(){
		return phone;
	}
}