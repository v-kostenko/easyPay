package com.easypay.api.auth_stage;

import com.easypay.api.easyPayAuth.pojo.auth.AuthUser;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;

import static io.restassured.RestAssured.given;

public class BaseTestApiStage {
    protected String appId = "";
    protected String pageId = "";
    protected String requestedSessionId = "";
    protected String accessToken = "";
    public CreateApp createApp;
    public static RequestSpecification specification;
    public static final String BASE_URL_STAGE = "https://apistage.easypay.ua/";


    @BeforeEach
    public void setUp() {
        createApp();

//        generateToken();
//
//        specification = new RequestSpecBuilder()
//                .setBaseUri(BASE_URL_STAGE)
//                //.setContentType(ContentType.JSON)
////                .addHeader("Accept", "application/json")
////                .addHeader("PartnerKey", "easypay-v2-test")
////                .addHeader("locale", "UA")
////                .addHeader("koatuu", "8000000000")
////                .addHeader("AppId", appId)
////                .addHeader("PageId", pageId)
////                .addHeader("Authorization", "Bearer " + accessToken)
//                .build();
    }

    private void generateToken() {
        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .addHeader("accept", "application/json")
                .addHeader("Locale", "UA")
                .addHeader("Content-Type", "application/json")
                .addHeader("PartnerKey", "easypay-v2")
                .addHeader("AppId", appId)
                .build();

        AuthUser authUser = new AuthUser("380660051447", "Qwerty1234");

        accessToken = given().spec(requestSpecification).body(authUser)
                .when().post("https://authstage.easypay.ua/api/auth/desktop")
                .then().extract().jsonPath().getString("data.access_token");
    }


    private void createApp() {
        createApp = given()
                .when().post("https://apistage.easypay.ua/api/system/createApp")
                .then().statusCode(200)
                .extract().as(CreateApp.class);

        appId = createApp.getAppId();
        pageId = createApp.getPageId();
        requestedSessionId = createApp.getRequestedSessionId();
    }


}
