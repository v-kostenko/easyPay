package api.easyPayAuth.pojo.delete;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeleteReason{

	@JsonProperty("id")
	private int id;

	@JsonProperty("content")
	private String content;

	@JsonProperty("isCanInput")
	private boolean isCanInput;

	@JsonProperty("priority")
	private int priority;

	@JsonProperty("isInputRequired")
	private boolean isInputRequired;


	public boolean isIsCanInput(){
		return isCanInput;
	}

	public boolean isIsInputRequired(){
		return isInputRequired;
	}

	public int getId(){
		return id;
	}

	public int getPriority(){
		return priority;
	}

	public String getContent(){
		return content;
	}
}