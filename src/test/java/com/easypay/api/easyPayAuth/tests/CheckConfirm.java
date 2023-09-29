package com.easypay.api.easyPayAuth.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class CheckConfirm extends BaseTestApi {
    private final String PATH = "/api/check/confirm";

    @Test
    @DisplayName("Invalid phone number")
    @Description("")
    @Owner("Volodymyr Kostenko")
    public void invalidFormInput() {
//        ApiConfirmCode confirmCode = new ApiConfirmCode("3800660051447", "203089");
//
//        given().spec(requestSpecification).body(confirmCode)
//                .when().post(BASE_URL_TEST + PATH)
//                .then().log().all()
//                .statusCode(400)
//                .body("error.errorCode", equalTo("INVALID_FORM_INPUT"));
    }

    @Test
    @Disabled
    @Owner("Volodymyr Kostenko")
    public void invalidConfirmationCode() {
        // First call check method

        String data = "{\n" +
                "    \"phone\":\"380660051447\",\n" +
                "    \"code\":\"200000\"\n" +
                "}";

        given().spec(requestSpecification).body(data)
                .when().post(BASE_URL_TEST + PATH)
                .then().log().all()
                .statusCode(400)
                .body("error.errorCode", equalTo("INVALID_CONFIRMATION_CODE"));
    }


}
