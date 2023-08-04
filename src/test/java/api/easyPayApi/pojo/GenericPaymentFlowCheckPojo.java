package api.easyPayApi.pojo;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GenericPaymentFlowCheckPojo {

	@JsonProperty("amount")
	private int amount;

	@JsonProperty("multyCheckPaymentStepIndex")
	private int multyCheckPaymentStepIndex;

	@JsonProperty("paymentTemplateId")
	private int paymentTemplateId;

	@JsonProperty("serviceKey")
	private String serviceKey;

	@JsonProperty("fields")
	private List<FieldsItem> fields;

	@JsonProperty("refererUrl")
	private String refererUrl;

	public GenericPaymentFlowCheckPojo(){

	}

	public GenericPaymentFlowCheckPojo(int amount, int multyCheckPaymentStepIndex, int paymentTemplateId, String serviceKey, List<FieldsItem> fields, String refererUrl) {
		this.amount = amount;
		this.multyCheckPaymentStepIndex = multyCheckPaymentStepIndex;
		this.paymentTemplateId = paymentTemplateId;
		this.serviceKey = serviceKey;
		this.fields = fields;
		this.refererUrl = refererUrl;
	}

	public int getAmount(){
		return amount;
	}

	public int getMultyCheckPaymentStepIndex(){
		return multyCheckPaymentStepIndex;
	}

	public int getPaymentTemplateId(){
		return paymentTemplateId;
	}

	public String getServiceKey(){
		return serviceKey;
	}

	public List<FieldsItem> getFields(){
		return fields;
	}

	public String getRefererUrl(){
		return refererUrl;
	}
}