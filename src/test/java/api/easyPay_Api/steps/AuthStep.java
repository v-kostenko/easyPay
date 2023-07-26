package api.easyPay_Api.steps;

import api.easyPay_Auth.pojo.auth.AuthUser;
import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.logevents.SelenideLogger.step;
import static io.restassured.RestAssured.given;

public class AuthStep {
   // private static Response response = null;
    private static Response createAppResponse;

    private static  String appId = createAppResponse.jsonPath().getString("appId");
    private static  String pageId = createAppResponse.jsonPath().getString("pageId");
    private static String requestedSessionId = createAppResponse.jsonPath().getString("requestedSessionId");



    public static void createApp(){
         createAppResponse = given()
                .when().post("https://apistage.easypay.ua/api/system/createApp")
                .then().statusCode(200)
                .extract().response();
    }


//    @Step(value = "Create new appId")
//    public static String createAppId() {
//        // В этом респонсе у меня 3 параметра которые мне нужны - appId, pageId, requestedSessionId
//        return given()
//                .when().post("https://apistage.easypay.ua/api/system/createApp")
//                .then().statusCode(200)
//                .extract().body().path("appId");
//    }

    @Step("Get desktop token")
    public static String getDesktopToken() {
        createApp();

        AuthUser authUser = new AuthUser("380958872559", "1234567Qq");

        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .addHeader("accept", "application/json")
                .addHeader("Locale", "UA")
                .addHeader("Content-Type", "application/json")
                .addHeader("PartnerKey", "easypay-v2")
                .addHeader("AppId", appId)
                .build();

        return given().spec(requestSpecification).body(authUser)
                .when().post("https://authstage.easypay.ua/api/auth/desktop")
                .then().extract().jsonPath().getString("data.access_token");
    }


}
