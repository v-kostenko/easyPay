package auth_api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojo.ApiCheckRequestBody;
import pojo.ApiConfirmRequestBody;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static io.restassured.filter.log.LogDetail.ALL;
import static org.hamcrest.Matchers.equalTo;

public class Check {
    private final String BASE_URL = "https://authtest.easypay.ua/api/check";

    private RequestSpecification requestSpecification = new RequestSpecBuilder()
            .addHeader("Content-type", "application/json")
            .addHeader("locale", "UA")
            // .addHeader("koatuu", "8000000000")
            // .addHeader("AppId", "68849a25-2740-4201-8cb6-5f5c01f1904e")
            .addHeader("PartnerKey", "easypay-ptks")
            // .setBaseUri(BASE_URL)
            // .addHeader("PageId", "68849a25-2740-4201-8cb6-5f5c01f1904e")
            .log(ALL)
            .build();

    private ResponseSpecification responseSpecification = new ResponseSpecBuilder()
            .log(ALL)
            .build();

    @Test
    public void wrongOtpCode() {
        ApiCheckRequestBody apiCheckRequestBody = new ApiCheckRequestBody("380660050002", "sms");
        given().spec(requestSpecification).body(apiCheckRequestBody)
                .when().post(BASE_URL)
                .then().spec(responseSpecification).statusCode(200);

        ApiConfirmRequestBody apiConfirmRequestBody = new ApiConfirmRequestBody("380660050002", "000000");
        given().spec(requestSpecification).body(apiConfirmRequestBody)
                .when().post(BASE_URL + "/confirm")
                .then().spec(responseSpecification).statusCode(400)
                .body("error.errorCode", equalTo("INVALID_CONFIRM_CODE"));
    }

    @Test
    public void wrongCallbackCode() {
        ApiCheckRequestBody apiCheckRequestBody = new ApiCheckRequestBody("380660050002", "callback");
        given().spec(requestSpecification).body(apiCheckRequestBody)
                .when().post(BASE_URL)
                .then().spec(responseSpecification).statusCode(200);

        ApiConfirmRequestBody apiConfirmRequestBody = new ApiConfirmRequestBody("380660050002", "0000");
        given().spec(requestSpecification).body(apiConfirmRequestBody)
                .when().post(BASE_URL + "/confirm")
                .then().spec(responseSpecification).statusCode(400)
                .body("error.errorCode", equalTo("INVALID_CONFIRM_CODE"));
    }

    @Test
    public void checkSecondsToExpireSms() throws InterruptedException {
        ApiCheckRequestBody apiCheckRequestBody = new ApiCheckRequestBody("380660050002", "sms");
        given().spec(requestSpecification).body(apiCheckRequestBody)
                .when().post(BASE_URL)
                .then().spec(responseSpecification).statusCode(200);

        // Thread.sleep( "secondsToExpire": 180 * 1000 + 1000);
        Thread.sleep(181000);
        ApiConfirmRequestBody apiConfirmRequestBody = new ApiConfirmRequestBody("380660050002", "000000");
        given().spec(requestSpecification).body(apiConfirmRequestBody)
                .when().post(BASE_URL + "/confirm")
                .then().spec(responseSpecification).statusCode(400)
                .body("error.errorCode", equalTo("VERIFICATION_CODE_ALREADY_EXPIRED"));
    }

    @Test
    public void checkSecondsToExpireCallback() {
        ApiCheckRequestBody apiCheckRequestBody = new ApiCheckRequestBody("380660050002", "callback");
        given().spec(requestSpecification).body(apiCheckRequestBody)
                .when().post(BASE_URL)
                .then().spec(responseSpecification).statusCode(200);

        // Thread.sleep( "secondsToExpire": 180 * 1000 + 1000);
        ApiConfirmRequestBody apiConfirmRequestBody = new ApiConfirmRequestBody("380660050002", "0000");
        given().spec(requestSpecification).body(apiConfirmRequestBody)
                .when().post(BASE_URL + "/confirm")
                .then().spec(responseSpecification).statusCode(400)
                .body("error.errorCode", equalTo("VERIFICATION_CODE_ALREADY_EXPIRED"));
    }


}
