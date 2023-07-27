package api.easyPay_Api.steps;

import api.easyPay_Api.tests.BaseTestApi;
import io.qameta.allure.Step;
import io.restassured.response.ResponseBodyData;

import static api.easyPay_Api.tests.BaseTestApi.specification;
import static io.restassured.RestAssured.given;

public class ProfileStep  {

    @Step("Get current profile")
    public void getCurrentProfile(){
        ResponseBodyData profile = given().spec(specification)
                .when().get("https://apistage.easypay.ua/api/profile/current")
                .then().extract().body();

    }


}
