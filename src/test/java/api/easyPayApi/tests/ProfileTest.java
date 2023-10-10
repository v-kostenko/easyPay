package api.easyPayApi.tests;

import api.easyPayApi.pojo.Locale;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;


public class ProfileTest extends BaseTest {

    @Test
    @DisplayName("Get current profile")
    @Owner("Volodymyr Kostenko")
    public void getCurrentProfile() {
        step("", () -> {

        });
        given().spec(specification)
                .when().get("https://apidev.easypay.ua/api/profile/current")
                .then().log().all()
                .statusCode(200);

//       ResponseBodyData profile = given().spec(specification)
//                .when().get("https://apistage.easypay.ua/api/profile/current")
//                .then().extract().body();
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
