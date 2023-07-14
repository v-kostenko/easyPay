package auth_api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static io.restassured.filter.log.LogDetail.ALL;

public class Check {
    private RequestSpecification requestSpecification = new RequestSpecBuilder()
            .addHeader("Content-type", "application/json")
            .addHeader("locale", "UA")
            .addHeader("koatuu", "8000000000")
            .addHeader("AppId", "68849a25-2740-4201-8cb6-5f5c01f1904e")
            .addHeader("PartnerKey", "easypay-v2")
            .addHeader("PageId", "68849a25-2740-4201-8cb6-5f5c01f1904e")
            .log(ALL)
            .build();


    @Test
    public void cantCastAppId(){
        given().spec(requestSpecification)
                .when().post("https://authtest.easypay.ua/api/check")
                .then();

    }




}
