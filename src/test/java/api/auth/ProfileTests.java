package api.auth;

import api.auth.payloads.Address;
import api.auth.payloads.UserProfileData;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@Tag("api")
public class ProfileTests extends BaseTestApiStage{
    private static final String PATH = "/api/users/profile";

    @Test
    @DisplayName("Call method 'get/users/profile' as not authorised user")
    @Owner("Volodymyr Kostenko")
    public void getProfileNotAuthorisedUser(){
        given().spec(specification)
                .when().get(BASE_URL + PATH)
                .then().log().all()
                .statusCode(401);
    }

    @Test
    @DisplayName("Call method 'get/users/profile' as authorised user")
    @Owner("Volodymyr Kostenko")
    public void getProfileAuthorisedUser(){
        given().spec(specification).header("Authorization", "Bearer " + accessToken)
                .when().get(BASE_URL + PATH)
                .then().log().all()
                .statusCode(200);
    }

    @Test
    public void setUserProfileData(){
        UserProfileData userProfileData = new UserProfileData("Test_Name", "Test_Last_Name", true,
                true, new Address("000000", "Test_street", "12A", "33/1"),
                true, "Test_location", "UA", "test@mail.com", true);

        given().log().all().spec(specification).header("Authorization", "Bearer " + accessToken).body(userProfileData)
                .when().post(BASE_URL + PATH)
                .then().log().all().statusCode(200);
    }









}
