package com.easypay.api.easyPayAuth.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@Tag("api")
public class Check extends BaseTestApi{
    private final String PATH = "/api/check";

    @Test
    @DisplayName("Incorrect phone format")
    @Description("In the body input Incorrect phone format")
    @Owner("Volodymyr Kostenko")
    @Severity(value = SeverityLevel.NORMAL)
    @Issue(value = "JIRA-111")
    public void incorrectPhoneFormat(){
//        ApiCheckChannel channel = new ApiCheckChannel("3800660051447", "sms");
//        given().spec(requestSpecification).body(channel)
//                .when().post(BASE_URL_TEST + PATH)
//                .then().log().all().statusCode(400)
//                .body("error.errorCode", equalTo("INVALID_FORM_INPUT"));
    }

    @Test
    @DisplayName(value = "Checking the method com.easypay.api/check new user")
    @Description("GetSmsCodeSentStatusNeedOtpT")
    @Owner("Volodymyr Kostenko")
    public void apiCheckNewUser(){
     //   ApiCheckChannel newUser = new ApiCheckChannel("380660051447", "sms");

//        given().spec(requestSpecification).body(newUser)
//                .when().post(BASE_URL_TEST + PATH)
//                .then().log().all().statusCode(200)
//                .body("data", equalTo("SMS_CODE_SENT"));
    }

    @Test
    @DisplayName("Already registered user")
    @Description("First we should register user and after that call endpoint with this user")
    @Disabled
    @Owner("Volodymyr Kostenko")
    public void apiCheckAlreadyRegisteredUser(){
//        ApiCheckChannel user = new ApiCheckChannel("380660051447", "sms");
//        // registerUser(User user);
//
//        given().spec(requestSpecification).body(user)
//                .when().post(BASE_URL_TEST + PATH)
//                .then().log().all().statusCode(200)
//                .body("data", equalTo("ALREDY_REGISTERED"));
    }









}
