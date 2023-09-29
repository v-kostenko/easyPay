package com.easypay.api.easyPayApi.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FieldsItem{

	@JsonProperty("fieldName")
	private String fieldName;

	@JsonProperty("fieldKey")
	private Object fieldKey;

	@JsonProperty("fieldValueDescription")
	private String fieldValueDescription;

	@JsonProperty("fieldValue")
	private String fieldValue;

	public FieldsItem(String fieldName, Object fieldKey, String fieldValueDescription, String fieldValue) {
		this.fieldName = fieldName;
		this.fieldKey = fieldKey;
		this.fieldValueDescription = fieldValueDescription;
		this.fieldValue = fieldValue;
	}

	public FieldsItem(){

	}

	public String getFieldName(){
		return fieldName;
	}

	public Object getFieldKey(){
		return fieldKey;
	}

	public String getFieldValueDescription(){
		return fieldValueDescription;
	}

	public String getFieldValue(){
		return fieldValue;
	}
}