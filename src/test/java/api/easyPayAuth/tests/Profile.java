package api.easyPayAuth.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@Tag("api")
public class Profile extends BaseTestApi {
    protected RequestSpecification desktopRequestSpecification = new RequestSpecBuilder()
            .addHeader("Locale", "UA")
            .addHeader("AppId", "e580032b-b20a-4950-a608-a36b4e5feba3")
            .addHeader("PartnerKey", "easypay-v2-test") // v2-сайт, v2-ios , v2-android, v2-ptks
            .addHeader("accept", "application/json")
            .log(LogDetail.ALL)
            .build();

    @Test
    @DisplayName(value = "Get user profile")
    @Owner("Volodymyr Kostenko")
    @Description("Get user's profile info after authorization and check phone number.")
    public void getUserProfile() {
        given().spec(desktopRequestSpecification).header("Authorization", "Bearer " + TOKEN)
                .when().get(BASE_URL_TEST + "/api/users/profile")
                .then().log().all()
                .statusCode(200)
                .body("data.phone", equalTo(authUser.getPhone()));
    }










}
