package com.easypay.api.auth_stage;

import com.easypay.api.auth_stage.payloads.AuthDesktop;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.easypay.api.auth_stage.constants.Constants.PASSWORD;
import static com.easypay.api.auth_stage.constants.Constants.PHONE;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@Tag("api")
public class DesktopAuthTests extends BaseTestApiStage {
    private final String PATH = "/api/auth/desktop";

    // TODO
    // Errors:
    // "NEED_TO_REAUTH" - if user is in cache, but device dont
    // "PASSWORD_CHECK_FAILED" - if pin and cached pin not equals
    // "NEED_SAFETY_CHECK" - if user attemtps to auth exceeded(user block after attempts check)
    // +++ "CANT_CAST_APP_ID" - if provided appid header cant be casted to uuid
    // "USER_RESTORE_NEEDED" - if user is in remove or locked state in db
    // "USER_DEVICE_NOT_EXISTS" - if provided appid is not in db

    @Test
    @DisplayName("Call 'auth/desktop' by registered user")
    @Owner("Volodymyr Kostenko")
    public void authDesktop() {
        given().spec(specification)
                .body(new AuthDesktop(PHONE, PASSWORD))
                .when().post(BASE_URL + PATH)

                .then().log().all()
                .statusCode(200)
                .body("data.access_token", not(isEmptyString()))
                .body("data.refresh_token", not(isEmptyString()));
    }

    @Test
    @DisplayName("Check error handling 'INVALID_PASSWORD'")
    @Owner("Volodymyr Kostenko")
    public void loginWithInvalidPassword() {
        given().spec(specification)
                .body(new AuthDesktop(PHONE, PASSWORD + "xxx"))
                .when().post(BASE_URL + PATH)

                .then().log().all()
                .statusCode(400)
                .body("error.errorCode", equalTo("INVALID_PASSWORD"));
    }

    @Test
    @DisplayName("Check error handling 'INVALID_FORM_INPUT'")
    @Owner("Volodymyr Kostenko")
    public void loginWithInvalidPhoneNumber() {
        given().spec(specification)
                .body(new AuthDesktop("38066", PASSWORD))
                .when().post(BASE_URL + PATH)

                .then().log().all()
                .statusCode(400)
                .body("error.errorCode", equalTo("INVALID_FORM_INPUT"));
    }

    @Test
    @DisplayName("Check error handling 'CANT_CAST_APP_ID'")
    @Owner("Volodymyr Kostenko")
    public void cantCastAppId() {
        given().spec(specification).header("AppId", appId + "xxx")
                .body(new AuthDesktop(PHONE, PASSWORD))
                .when().post(BASE_URL + PATH)

                .then().log().all()
                .statusCode(400)
                .body("error.errorCode", equalTo("CANT_CAST_APP_ID"));
    }

    @Test
    @DisplayName("Check error handling 'INVALID_PARTNERKEY'")
    @Owner("Volodymyr Kostenko")
    public void invalidPartnerKey() {
        given().spec(specification)
                .body(new AuthDesktop(PHONE, PASSWORD))
                .when().post(BASE_URL + PATH)

                .then().log().all()
                .statusCode(400)
                .body("error.errorCode", equalTo("INVALID_PARTNERKEY"));
    }


    @Test
    public void foo() {

    }


}
