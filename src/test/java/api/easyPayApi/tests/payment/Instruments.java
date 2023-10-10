package api.easyPayApi.tests.payment;

import api.easyPayApi.tests.BaseTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class Instruments extends BaseTest {

    @Test
    public void getInstruments(){
        given().log().all().spec(specification)
                .when().get("https://apistage.easypay.ua/api/payment/instruments")
                .then().log().all()
                .statusCode(200);
    }


}
