package auth_api;

import createAppPojo.CreateApp;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pojo.auth.AuthUser;

import static io.restassured.RestAssured.given;
import static io.restassured.filter.log.LogDetail.ALL;
import static org.hamcrest.Matchers.equalTo;

public class Profile extends BaseTest {

    @Test
    @Owner("Volodymyr Kostenko")
    @Description("Get user's profile info after authorization and check phone number.")
    public void getUserProfife() {
        given().spec(requestSpecification).header("Authorization", "Bearer " + TOKEN)
                .when().get(BASE_URL_STAGE + "/api/users/profile")
                .then().log().all()
                .statusCode(200).body("data.phone", equalTo(authUser.getPhone()));
    }









}
