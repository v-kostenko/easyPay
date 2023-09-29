package com.easypay.api.easyPayApi.steps;

import io.qameta.allure.Step;
import io.restassured.response.ResponseBodyData;

import static com.easypay.api.easyPayApi.tests.BaseTestApi.specification;
import static io.restassured.RestAssured.given;

public class ProfileStep  {

    @Step("Get current profile")
    public void getCurrentProfile(){
        ResponseBodyData profile = given().spec(specification)
                .when().get("https://apistage.easypay.ua/api/profile/current")
                .then().extract().body();

    }


}
