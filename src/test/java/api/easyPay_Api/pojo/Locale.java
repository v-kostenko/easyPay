package api.easyPay_Api.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Locale{

	@JsonProperty("locale")
	private String locale;

	public String getLocale(){
		return locale;
	}
}