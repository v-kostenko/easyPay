package com.easypay.api.easyPayApi.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@Tag("api")
public class MerchantTests extends BaseTestApi {

    @Test
    public void getMerchantCardInfoWithFullName() {
        given().spec(specification)
                .queryParam("cardPan", "")
                .queryParam("cardGuid").queryParam("")
                .queryParam("isFullName", "true").
                when().get("https://apidev.easypay.ua/api/merchant/cardInfo").
                then().statusCode(200);
    }

    @Test
    public void getMerchantCardInfoWithOutFullName() {
        given().spec(specification)
                .queryParam("cardPan", "")
                .queryParam("cardGuid").queryParam("")
                .queryParam("isFullName", "false").
                when().get("https://apidev.easypay.ua/api/merchant/cardInfo").
                then().statusCode(200);
    }


}
