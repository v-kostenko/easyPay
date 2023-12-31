package api.easyPayAuth.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;



public class AuthTerminal extends Base {

    private static final String PATH = "/api/auth/terminal";


    @Test
    @DisplayName("Try to login by pin-code")
    @Description("We had ability ti login by pin code. Now only by OPT-code ore callback-code")
    @Owner("Volodymyr Kostenko")
    @Severity(SeverityLevel.NORMAL)
    @Issue("ENF-7461")
    public void tryToLoginByPinCode() {
        String body = "{\n" +
                "    \"phone\":\"380660051447\",\n" +
                "    \"pin\":\"0000\"\n" +
                "}";
        given().spec(requestSpecification).body(body)
                .when().post(BASE_URL_TEST + PATH)
                .then().log().all().statusCode(400)
                .body("error.errorCode", equalTo("VERIFICATION_CODE_ALREADY_EXPIRED"));
    }




}
