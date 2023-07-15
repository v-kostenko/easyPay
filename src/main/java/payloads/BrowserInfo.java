package payloads;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BrowserInfo{

	@JsonProperty("screenWidth")
	private String screenWidth;

	@JsonProperty("javaEnabled")
	private boolean javaEnabled;

	@JsonProperty("screenHeight")
	private String screenHeight;

	@JsonProperty("timeZone")
	private String timeZone;

	@JsonProperty("language")
	private String language;

	@JsonProperty("colorDepth")
	private String colorDepth;

	public String getScreenWidth(){
		return screenWidth;
	}

	public boolean isJavaEnabled(){
		return javaEnabled;
	}

	public String getScreenHeight(){
		return screenHeight;
	}

	public String getTimeZone(){
		return timeZone;
	}

	public String getLanguage(){
		return language;
	}

	public String getColorDepth(){
		return colorDepth;
	}
}