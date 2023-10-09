package api.auth;

import api.auth.payloads.CheckConfirmPhoneCode;
import api.auth.payloads.CheckPhoneChannel;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static api.auth.constants.Constants.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@Tag("api")
public class CheckConfirmTests extends BaseTestApiStage{
    private static final String PATH = "/api/check/confirm";

    @Test
    @DisplayName("Check error handling 'CANT_CAST_APP_ID'")
    @Owner("Volodymyr Kostenko")
    public void cantCastAppId() {
        given().spec(specificationNoAppId).body(new CheckConfirmPhoneCode(PHONE, "000000"))
                .when().post(BASE_URL + PATH)
                .then().log().all()
                .statusCode(400)
                .body("error.errorCode", equalTo("CANT_CAST_APP_ID"));
    }

    @Test
    @DisplayName("Check error handling 'INVALID_FORM_INPUT'")
    @Owner("Volodymyr Kostenko")
    public void checkInvalidFormInput() {
        given().spec(specification).body(new CheckConfirmPhoneCode(PHONE + "000", "000000"))
                .when().post(BASE_URL + PATH)
                .then().log().all()
                .statusCode(400)
                .body("error.errorCode", equalTo("INVALID_FORM_INPUT"));
    }

    @Test
    @DisplayName("Check error handling 'VERIFICATION_CODE_ALREADY_EXPIRED'")
    @Owner("Volodymyr Kostenko")
    public void checkCodeAlreadyExpired(){
        given().spec(specification).body(new CheckConfirmPhoneCode(PHONE, "000000"))
                .when().post(BASE_URL + PATH)
                .then().log().all()
                .statusCode(400)
                .body("error.errorCode", equalTo("VERIFICATION_CODE_ALREADY_EXPIRED"));
    }

    @Test
    @DisplayName("Check error handling 'INVALID_CONFIRM_CODE'")
    @Owner("Volodymyr Kostenko")
    public void checkInvalidConfirmationCode(){
        given().spec(specification).body(new CheckPhoneChannel(PHONE_UNREGISTERED, CHANNEL_SMS))
                .when().post(BASE_URL + "/api/check")
                .then().log().all()
                .statusCode(200)
                .body("data.codeType", equalTo("SMS_CODE_SENT"));

        given().spec(specification).body(new CheckConfirmPhoneCode(PHONE_UNREGISTERED, "000000"))
                .when().post(BASE_URL + PATH)
                .then().log().all()
                .statusCode(400)
                .body("error.errorCode", equalTo("INVALID_CONFIRM_CODE"));
    }



}
