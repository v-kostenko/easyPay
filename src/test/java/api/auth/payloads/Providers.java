package api.auth.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Providers {

	@JsonProperty("name")
	private String name;

	@JsonProperty("description")
	private String description;

	@JsonProperty("icon")
	private String icon;

	public Providers() {
	}

	public Providers(String name, String description, String icon) {
		this.name = name;
		this.description = description;
		this.icon = icon;
	}

	public String getName(){
		return name;
	}

	public String getIcon(){
		return icon;
	}

	public String getDescription(){
		return description;
	}

	@Override
	public String toString() {
		return "Providers{" +
				"name='" + name + '\'' +
				", description='" + description + '\'' +
				", icon='" + icon + '\'' +
				'}';
	}
}