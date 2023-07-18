package createAppPojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateApp{

	@JsonProperty("apiVersion")
	private String apiVersion;

	@JsonProperty("logoPath")
	private String logoPath;

	@JsonProperty("appId")
	private String appId;

	@JsonProperty("requestedSessionId")
	private String requestedSessionId;

	@JsonProperty("pageId")
	private String pageId;

	@JsonProperty("error")
	private Object error;

	@JsonProperty("hintImagesPath")
	private String hintImagesPath;

	public String getApiVersion(){
		return apiVersion;
	}

	public String getLogoPath(){
		return logoPath;
	}

	public String getAppId(){
		return appId;
	}

	public String getRequestedSessionId(){
		return requestedSessionId;
	}

	public String getPageId(){
		return pageId;
	}

	public Object getError(){
		return error;
	}

	public String getHintImagesPath(){
		return hintImagesPath;
	}

	@Override
	public String toString() {
		return "CreateApp{" +
				"apiVersion='" + apiVersion + '\'' +
				", logoPath='" + logoPath + '\'' +
				", appId='" + appId + '\'' +
				", requestedSessionId='" + requestedSessionId + '\'' +
				", pageId='" + pageId + '\'' +
				", error=" + error +
				", hintImagesPath='" + hintImagesPath + '\'' +
				'}';
	}
}