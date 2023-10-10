package api.auth;

import api.auth.payloads.CheckPhoneChannel;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static api.auth.constants.Constants.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@Tag("api")
public class CheckTests extends BaseTestApi {
    private static final String PATH = "/api/check";

    @Test
    @DisplayName("Check error handling 'CANT_CAST_APP_ID'")
    @Owner("Volodymyr Kostenko")
    public void cantCastAppId() {
        given().spec(specificationNoAppId).body(new CheckPhoneChannel(PHONE, CHANNEL_SMS))
                .when().post(BASE_URL + PATH)
                .then().log().all()
                .statusCode(400)
                .body("error.errorCode", equalTo("CANT_CAST_APP_ID"));
    }

    @Test
    @DisplayName("Already registered user. Check 'codeType' = 'ALREDY_REGISTERED'")
    @Owner("Volodymyr Kostenko")
    public void alreadyRegisteredUserChannelSms() {
        given().spec(specification).body(new CheckPhoneChannel(PHONE, CHANNEL_SMS))
                .when().post(BASE_URL + PATH)
                .then().log().all()
                .statusCode(200)
                .body("data.codeType", equalTo("ALREADY_REGISTERED"));
    }

    @Test
    @DisplayName("Unregistered user. Check 'codeType' = 'SMS_CODE_SENT'")
    @Owner("Volodymyr Kostenko")
    public void smsCodeSent(){
        given().spec(specification).body(new CheckPhoneChannel(PHONE_UNREGISTERED, CHANNEL_SMS))
                .when().post(BASE_URL + PATH)
                .then().log().all()
                .statusCode(200)
                .body("data.codeType", equalTo("SMS_CODE_SENT"));
    }

    @Test
    @DisplayName("Check error handling 'INVALID_FORM_INPUT'")
    @Owner("Volodymyr Kostenko")
    public void checkInvalidFormInput() {
        given().spec(specification).body(new CheckPhoneChannel(PHONE + "000", CHANNEL_SMS))
                .when().post(BASE_URL + PATH)
                .then().log().all()
                .statusCode(400)
                .body("error.errorCode", equalTo("INVALID_FORM_INPUT"));
    }


}
