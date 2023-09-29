package com.easypay.api.easyPayApi.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class BlogTests extends BaseTestApi {

    @Test
    public void getBlogVideo(){
        given().spec(specification)
                .when().get("https://apistage.easypay.ua/api/blog/Video")
                .then().log().all().statusCode(200);
    }

    @Test
    public void getBlogVideoById(){
        given().spec(specification).queryParam("id", "1")
                .when().get("https://apistage.easypay.ua/api/blog/VideoById")
                .then().log().all().statusCode(200)
                .body("video.id", equalTo(1));
    }

    @Test
    public void getBlogVideoByNotExistingId(){
        given().spec(specification).queryParam("id", "-1")
                .when().get("https://apistage.easypay.ua/api/blog/VideoById")
                .then().log().all().statusCode(200)
                .body("video", equalTo(null));
    }


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
