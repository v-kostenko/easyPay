package com.easypay.api.auth_stage;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@Tag("api")
public class ProfileTests extends BaseTestApiStage{
    private final String PATH = "/api/users/profile";

    @Test
    @DisplayName("Call method as not authorised user")
    @Owner("Volodymyr Kostenko")
    public void getProfileNotAuthorisedUser(){
        given().spec(specification)
                .when().get(BASE_URL + PATH)
                .then().log().all()
                .statusCode(401);
    }

    @Test
    @DisplayName("Call method as authorised user")
    @Owner("Volodymyr Kostenko")
    public void getProfileAuthorisedUser(){
        given().spec(specification).header("Authorization", "Bearer " + accessToken)
                .when().get(BASE_URL + PATH)
                .then().log().all()
                .statusCode(200);
    }




}
