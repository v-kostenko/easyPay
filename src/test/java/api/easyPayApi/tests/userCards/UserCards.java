package api.easyPayApi.tests.userCards;

import api.easyPayApi.tests.BaseTest;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.path.json.JsonPath.from;

public class UserCards extends BaseTest {
    protected  final String BASE_URL = "https://apistage.easypay.ua";


    @Test
    @Owner("Volodymyr Kostenko")
    public void getUserCards(){
        given().spec(specification)
                .when().get(BASE_URL + "/api/cards/get")
                .then().log().all().statusCode(200);
    }

    @Test
    @Owner("Volodymyr Kostenko")
    public void getUserCardsBody(){
        String response = given().spec(specification)
                .when().get(BASE_URL + "/api/cards/get")
                .then().log().all().statusCode(200)
                .extract().response().asString();

        List<String> idList = from(response).getList("$.cards[*].instrumentId");

       // System.out.println(idList.size());
    }




}
