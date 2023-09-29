package com.easypay.api.easyPayApi.tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;


public class GenericPaymentFlowCheck extends BaseTestApi {

    @Test
    @Owner("Volodymyr Kostenko")
    @Disabled
    public void too() {
//        FieldsItem item = new FieldsItem("Account", null, "", "380660051447");
//        List<FieldsItem> fieldItemList = new ArrayList<>();
//        fieldItemList.add(item);
//
//        GenericPaymentFlowCheckPojo check =
//                new GenericPaymentFlowCheckPojo(1, 0, 0, "VODAFONE", fieldItemList, "https://bla");

        String body = "{ \n" +
                "   \"amount\": 1, \n" +
                "   \"serviceKey\": \"VODAFONE\", \n" +
                "   \"fields\": [  \n" +
                "     {  \n" +
                "       \"fieldName\": \"Account\",  \n" +
                "       \"fieldValue\": \"380660051447\", \n" +
                "       \"fieldKey\": null,  \n" +
                "       \"fieldValueDescription\": \"\"  \n" +
                "     }  \n" +
                "   ],  \n" +
                "   \"paymentTemplateId\": 0,  \n" +
                "   \"refererUrl\": \"string\",  \n" +
                "   \"multyCheckPaymentStepIndex\": 0 \n" +
                " }";


        given().spec(specification).header("Content-Type", "application/json").log().all().body(body)
                .when().post("https://api.easypay.ua/api/genericPaymentFlow/payment")
                .then().log().all().statusCode(200);
    }


}
