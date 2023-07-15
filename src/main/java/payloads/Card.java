package payloads;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Card{

	@JsonProperty("cvv")
	private String cvv;

	@JsonProperty("color")
	private String color;

	@JsonProperty("expire")
	private String expire;

	@JsonProperty("alias")
	private String alias;

	@JsonProperty("resultUrl")
	private String resultUrl;

	@JsonProperty("pan")
	private String pan;

	@JsonProperty("browserInfo")
	private BrowserInfo browserInfo;

	public String getCvv(){
		return cvv;
	}

	public String getColor(){
		return color;
	}

	public String getExpire(){
		return expire;
	}

	public String getAlias(){
		return alias;
	}

	public String getResultUrl(){
		return resultUrl;
	}

	public String getPan(){
		return pan;
	}

	public BrowserInfo getBrowserInfo(){
		return browserInfo;
	}
}