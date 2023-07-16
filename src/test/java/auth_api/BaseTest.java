package auth_api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeEach;
import pojo.auth.AuthUser;

import static io.restassured.RestAssured.given;
import static io.restassured.filter.log.LogDetail.ALL;

public abstract class BaseTest {
    protected final String BASE_URL_STAGE = "https://authstage.easypay.ua";
    protected static String TOKEN = "";
    protected RequestSpecification requestSpecification = new RequestSpecBuilder()
            .addHeader("Content-type", "application/json")
            .addHeader("locale", "UA")
            .addHeader("koatuu", "8000000000")
            .addHeader("AppId", "68849a25-2740-4201-8cb6-5f5c01f1904e")
            .addHeader("PartnerKey", "easypay-v2")
            .addHeader("PageId", "68849a25-2740-4201-8cb6-5f5c01f1904e")
            //.addHeader("Authorization", "Bearer " + TOKEN)
            .log(ALL)
            .build();
    protected ResponseSpecification responseSpecification = new ResponseSpecBuilder()
            .log(ALL)
            .build();
    protected AuthUser authUser = new AuthUser("380660051447", "Qwerty1234");

    @BeforeEach
    public void authorization() {
        TOKEN = given().spec(requestSpecification).body(authUser)
                .when().post("https://authstage.easypay.ua/api/auth/desktop")
                .then().extract().jsonPath().getString("data.access_token");
    }



}
