package api.auth.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeleteUser{

	@JsonProperty("confirmCode")
	private String confirmCode;

	@JsonProperty("reasonContent")
	private String reasonContent;

	@JsonProperty("reasonId")
	private int reasonId;

	public DeleteUser() {
	}

	public DeleteUser(int reasonId, String reasonContent, String confirmCode) {
		this.confirmCode = confirmCode;
		this.reasonContent = reasonContent;
		this.reasonId = reasonId;
	}

	public DeleteUser(int reasonId){
		this.reasonId = reasonId;
	}

	public String getConfirmCode(){
		return confirmCode;
	}

	public String getReasonContent(){
		return reasonContent;
	}

	public int getReasonId(){
		return reasonId;
	}
}