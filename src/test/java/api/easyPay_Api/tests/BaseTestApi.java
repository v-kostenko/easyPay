package api.easyPay_Api.tests;

import api.easyPay_Auth.pojo.auth.AuthUser;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static io.restassured.RestAssured.given;

public class BaseTestApi {
    protected String appId = "";
    protected String pageId = "";
    protected String requestedSessionId = "";
    protected String token = "";
    protected RequestSpecification specification;

    @BeforeEach
    public void setUp() {
        Response createAppResponse = given()
                .when().post("https://apistage.easypay.ua/api/system/createApp")
                .then().statusCode(200)
                .extract().response();

        appId = createAppResponse.jsonPath().getString("appId");
        pageId = createAppResponse.jsonPath().getString("pageId");
        // requestedSessionId = createAppResponse.jsonPath().getString("requestedSessionId");

        generateToken();

        specification = new RequestSpecBuilder()
                .addHeader("Accept", "application/json")
                .addHeader("PartnerKey", "easypay-v2")
                .addHeader("locale", "UA")
                .addHeader("koatuu", "8000000000")
                .addHeader("AppId", appId)
                .addHeader("PageId", pageId)
                .addHeader("Authorization", "Bearer " + token)
                .build();
    }

    private void generateToken() {
        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .addHeader("accept", "application/json")
                .addHeader("Locale", "UA")
                .addHeader("Content-Type", "application/json")
                .addHeader("PartnerKey", "easypay-v2")
                .addHeader("AppId", appId)
                .build();

        AuthUser authUser = new AuthUser("380958872559", "1234567Qq");

        token = given().spec(requestSpecification).body(authUser)
                .when().post("https://authstage.easypay.ua/api/auth/desktop")
                .then().extract().jsonPath().getString("data.access_token");
    }


}
