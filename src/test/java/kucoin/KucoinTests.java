package kucoin;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class KucoinTests {
    public final String BASE_URL = "https://api.kucoin.com";

    public List<TickerData> getAllTickers() {
        return given().contentType(ContentType.JSON).log().all()
                .when().get(BASE_URL + "/api/v1/market/allTickers")
                .then().log().all().extract().jsonPath().getList("data.ticker", TickerData.class);
    }

    @Test
    public void checkAllTickers() {
        given().contentType(ContentType.JSON).log().all()
                .when().get(BASE_URL + "/api/v1/market/allTickers")
                .then().log().all().statusCode(200);
    }





}
