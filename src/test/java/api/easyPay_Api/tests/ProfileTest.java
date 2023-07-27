package api.easyPay_Api.tests;

import api.easyPay_Api.pojo.Locale;
import io.qameta.allure.Owner;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@Tag("api")
public class ProfileTest extends BaseTestApi {

    @Test
    @DisplayName("Get current profile")
    @Owner("Volodymyr Kostenko")
    public void getCurrentProfile() {
        given().spec(specification)
                .when().get("https://apistage.easypay.ua/api/profile/current")
                .then().log().all()
                .statusCode(200)
                .body("user.id", equalTo("1111"));

       ResponseBodyData profile = given().spec(specification)
                .when().get("https://apistage.easypay.ua/api/profile/current")
                .then().extract().body();
    }

    @Test
    @DisplayName("Get profile locale")
    @Owner("Volodymyr Kostenko")
    public void getProfileLocale() {
        given().spec(specification)
                .when().get("https://apistage.easypay.ua/api/profile/locale")
                .then().log().all()
                .statusCode(200);
    }

    @Test
    @DisplayName("Set profile locale")
    @Owner("Volodymyr Kostenko")
    public void setProfileLocale() {
        // locale (string, optional) = ['Ua', 'En', 'Ru']
        Locale locale = new Locale("Ua");
        given().spec(specification).header("Content-Type", "application/json").body(locale)
                .when().post("https://apidev.easypay.ua/api/profile/locale")
                .then().log().all()
                .statusCode(200);
    }


}
