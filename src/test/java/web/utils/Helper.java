package web.utils;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import web.pageObjects.PaymentsPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static web.pageObjects.MainPage.*;
import static web.pageObjects.PaymentsPage.profileHeaderTitle;

public class Helper {

    @Step("Success login")
    public static void successLogin(String phone, String password) {
        headerLoginButton.shouldBe(visible).click();
        phoneInput.shouldBe(visible).sendKeys(phone);
        passwordInput.shouldBe(visible).sendKeys(password);
        authLoginButton.click();
        profileHeaderTitle.shouldBe(visible, Duration.ofSeconds(30));
    }



}
