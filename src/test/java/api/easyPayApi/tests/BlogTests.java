package api.easyPayApi.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@Tag("api")
public class BlogTests extends BaseTestApi {


    @Test
    public void getBlogItems() {
        given().log().all().spec(specification).
                when().get("https://apistage.easypay.ua/api/blog/BlogItems")
                .then().log().all().statusCode(200);
    }

    @Test
    public void getBlogItemsWithQueryParams() {
        given().log().all().spec(specification).queryParam("model.value", "/personaldata/registration").
                when().get("https://apistage.easypay.ua/api/blog/BlogItems")
                .then().log().all().statusCode(200);
    }


}
