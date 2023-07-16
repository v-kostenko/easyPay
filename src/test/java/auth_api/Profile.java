package auth_api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pojo.auth.AuthUser;

import static io.restassured.RestAssured.given;
import static io.restassured.filter.log.LogDetail.ALL;
import static org.hamcrest.Matchers.equalTo;

public class Profile extends BaseTest{

    @Test
    public void getUserProfife() {
        given().spec(requestSpecification).header("Authorization", "Bearer " + TOKEN)
                .when().get(BASE_URL_STAGE + "/api/users/profile")
                .then().log().all()
                .statusCode(200).body("data.phone", equalTo(authUser.getPhone()));
    }


}
