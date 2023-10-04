package api.auth_stage;

import api.auth_stage.payloads.AuthDesktop;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static api.auth_stage.constants.Constants.PASSWORD;
import static api.auth_stage.constants.Constants.PHONE;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AuthTerminalTests extends BaseTestApiStage{
    private static final String PATH = "/api/auth/terminal";

    // TODO
  //  "NEED_TO_REAUTH" - if user is in cache, but device dont
  // "PASSWORD_CHECK_FAILED" - if pin and cached pin not equals
  // "NEED_SAFETY_CHECK" - if user attemtps to auth exceeded(user block after attempts check)
  // "CANT_CAST_APP_ID" - if provided appid header cant be casted to uuid
  // "USER_RESTORE_NEEDED" - if user is in remove or locked state in db

    @Test
    @DisplayName("Check error handling 'CANT_CAST_APP_ID'")
    @Owner("Volodymyr Kostenko")
    @Disabled
    public void cantCastAppId(){
        given().spec(specificationPtksNoAppId)
                .body(new AuthDesktop(PHONE, PASSWORD))
                .when().post(BASE_URL + PATH)
                .then().log().all()
                .statusCode(400)
                .body("error.errorCode", equalTo("CANT_CAST_APP_ID"));
    }




}
