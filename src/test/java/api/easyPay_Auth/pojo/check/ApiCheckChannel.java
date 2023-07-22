package api.easyPay_Auth.pojo.check;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiCheckChannel {

	@JsonProperty("phone")
	private String phone;

	@JsonProperty("channel")
	private String channel;

	public ApiCheckChannel(String phone, String channel) {
		this.phone = phone;
		this.channel = channel;
	}

	public ApiCheckChannel(){
		
	}

	public String getPhone(){
		return phone;
	}

	public String getChannel(){
		return channel;
	}
}