package api.auth_stage.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeleteReasons{

	@JsonProperty("isCanInput")
	private boolean isCanInput;

	@JsonProperty("isInputRequired")
	private boolean isInputRequired;

	@JsonProperty("id")
	private int id;

	@JsonProperty("priority")
	private int priority;

	@JsonProperty("content")
	private String content;

	public DeleteReasons(boolean isCanInput, boolean isInputRequired, int id, int priority, String content) {
		this.isCanInput = isCanInput;
		this.isInputRequired = isInputRequired;
		this.id = id;
		this.priority = priority;
		this.content = content;
	}

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

	@Override
	public String toString() {
		return "DeleteReasons{" +
				"isCanInput=" + isCanInput +
				", isInputRequired=" + isInputRequired +
				", id=" + id +
				", priority=" + priority +
				", content='" + content + '\'' +
				'}';
	}
}