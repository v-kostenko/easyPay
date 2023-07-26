package api.easyPay_Api.tests;

import api.easyPay_Api.steps.AuthStep;
import api.easyPay_Auth.pojo.auth.AuthUser;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static api.easyPay_Api.steps.AuthStep.getDesktopToken;
import static io.restassured.RestAssured.given;

@Tag("api")
@Tag("regression")
public class Contacts {

    @Test
    @DisplayName("Get contacts")
    @Description("Get contacts")
    @Owner("Volodymyr Kostenko")
    @Severity(SeverityLevel.NORMAL)
    public void getContacts() {
        // Get createApp -----------
        Response createAppResponse = given()
                .when().post("https://apistage.easypay.ua/api/system/createApp")
                .then().statusCode(200)
                .extract().response();

        String appId = createAppResponse.jsonPath().getString("appId");
        String pageId = createAppResponse.jsonPath().getString("pageId");

        // Get token -----------
        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .addHeader("accept", "application/json")
                .addHeader("Locale", "UA")
                .addHeader("Content-Type", "application/json")
                .addHeader("PartnerKey", "easypay-v2")
                .addHeader("AppId", appId)
                .build();

        AuthUser authUser = new AuthUser("380958872559", "1234567Qq");

        String token = given().spec(requestSpecification).body(authUser)
                .when().post("https://authstage.easypay.ua/api/auth/desktop")
                .then().extract().jsonPath().getString("data.access_token");

        // Test -----------
        RequestSpecification specification = new RequestSpecBuilder()
                .addHeader("Accept", "application/json")
                .addHeader("PartnerKey", "easypay-v2")
                .addHeader("locale", "UA")
                .addHeader("koatuu", "8000000000")
                .addHeader("AppId", appId)
                .addHeader("PageId", pageId)
                .addHeader("Authorization", "Bearer " + token)
                .build();

        given().spec(specification).log().all()
                .when().get("https://apistage.easypay.ua/api/contacts/get")
                .then().log().all().statusCode(200);
    }

    @Test
    @DisplayName("Get contact by existing id")
    @Owner("Volodymyr Kostenko")
    public void getContactById(){

        // Get createApp -----------
        Response createAppResponse = given()
                .when().post("https://apistage.easypay.ua/api/system/createApp")
                .then().statusCode(200)
                .extract().response();

        String appId = createAppResponse.jsonPath().getString("appId");
        String pageId = createAppResponse.jsonPath().getString("pageId");

        // Get token -----------
        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .addHeader("accept", "application/json")
                .addHeader("Locale", "UA")
                .addHeader("Content-Type", "application/json")
                .addHeader("PartnerKey", "easypay-v2")
                .addHeader("AppId", appId)
                .build();

        AuthUser authUser = new AuthUser("380958872559", "1234567Qq");

        String token = given().spec(requestSpecification).body(authUser)
                .when().post("https://authstage.easypay.ua/api/auth/desktop")
                .then().extract().jsonPath().getString("data.access_token");

        // Test -----------
        RequestSpecification specification = new RequestSpecBuilder()
                .addHeader("Accept", "application/json")
                .addHeader("PartnerKey", "easypay-v2")
                .addHeader("locale", "UA")
                .addHeader("koatuu", "8000000000")
                .addHeader("AppId", appId)
                .addHeader("PageId", pageId)
                .addHeader("Authorization", "Bearer " + token)
                .build();

        given().spec(specification).log().all()
                .when().get("https://apistage.easypay.ua/api/contacts/get/13")
                .then().log().all().statusCode(200);
    }


}
