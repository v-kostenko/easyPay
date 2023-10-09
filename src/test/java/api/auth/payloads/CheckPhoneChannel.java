package api.auth.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CheckPhoneChannel{

	@JsonProperty("phone")
	private String phone;

	@JsonProperty("channel")
	private String channel;

	public CheckPhoneChannel(String phone, String channel) {
		this.phone = phone;
		this.channel = channel;
	}

	public String getPhone(){
		return phone;
	}

	public String getChannel(){
		return channel;
	}
}