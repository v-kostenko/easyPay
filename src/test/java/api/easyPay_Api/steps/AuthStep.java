package api.easyPay_Api.steps;

import api.easyPay_Auth.pojo.auth.AuthUser;
import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.logevents.SelenideLogger.step;
import static io.restassured.RestAssured.given;

public class AuthStep {



    @Step("Get desktop token")
    public static void getDesktopToken() {

    }




}
