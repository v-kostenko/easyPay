package api.easyPay_Api.tests;

import api.easyPay_Auth.tests.BaseTestApi;
import io.qameta.allure.Owner;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.filter.log.LogDetail.ALL;

public class UserCards extends BaseTestApi {
    protected  final String BASE_URL = "https://apidev.easypay.ua";

    protected RequestSpecification requestSpecificationUser = new RequestSpecBuilder()
            .addHeader("locale", "UA")
            .addHeader("koatuu", "8000000000")
            .addHeader("AppId", "e580032b-b20a-4950-a608-a36b4e5feba3")
            .addHeader("PartnerKey", "easypay-v2") // v2-сайт, v2-ios , v2-android, v2-ptks
            .addHeader("PageId", "68849a25-2740-4201-8cb6-5f5c01f1904e")
            //.addHeader("Authorization", "Bearer " + TOKEN)
            .log(ALL)
            .build();

    @Test
    @Owner("Volodymyr Kostenko")
    public void getUserCards(){
        given().spec(requestSpecificationUser).header("Accept", "application/json").header("Authorization", "Bearer " + TOKEN)
                .when().get(BASE_URL + "/api/cards/get")
                .then().log().all().statusCode(200);
    }




}
