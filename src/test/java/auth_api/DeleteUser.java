package auth_api;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.filter.log.LogDetail.ALL;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class DeleteUser {
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
    public void getDeleteReason(){
        given().spec(requestSpecification)
                .when().get("https://authtest.easypay.ua/api/users/delete/reasons")
                .then().log().all()
                .statusCode(200)
                .body( "$..reasons.length()", hasSize(5));
    }

}
