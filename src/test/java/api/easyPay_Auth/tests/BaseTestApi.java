package api.easyPay_Auth.tests;

import api.easyPay_Auth.pojo.auth.AuthUser;
import io.restassured.RestAssured;
import io.restassured.authentication.BasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;

import static io.restassured.RestAssured.given;
import static io.restassured.filter.log.LogDetail.ALL;

public abstract class BaseTestApi {
    protected final String BASE_URL_TEST = "https://authtest.easypay.ua"; // только для authtest
    protected static String TOKEN = "";

    protected RequestSpecification requestSpecification = new RequestSpecBuilder()
            .addHeader("Content-type", "application/json")
            .addHeader("locale", "UA")
            .addHeader("koatuu", "8000000000")
            .addHeader("AppId", "e580032b-b20a-4950-a608-a36b4e5feba3")
            .addHeader("PartnerKey", "easypay-v2-test") // v2-сайт, v2-ios , v2-android, v2-ptks
            .addHeader("PageId", "68849a25-2740-4201-8cb6-5f5c01f1904e")
            //.addHeader("Authorization", "Bearer " + TOKEN)
            .log(ALL)
            .build();

    AuthUser authUser = new AuthUser("380958872559", "1234567Qq");


    @BeforeEach
    public void desktopAuthorization() {
        // Steps.desktopAuthorization();
        TOKEN = given().spec(requestSpecification).body(authUser)
                .when().post(BASE_URL_TEST + "/api/auth/desktop")
                .then().extract().jsonPath().getString("data.access_token");
    }


}
