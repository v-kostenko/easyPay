package web.utils;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import web.pageObjects.CatalogPopularPage;
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

    public static void clickHeaderLoginButton() {
        headerLoginButton.shouldBe(Condition.visible).click();
    }

    public static String getLoginFormTitle() {
        return loginFormTitle.shouldBe(Condition.enabled).getText();
    }

    public static String getPhoneErrorMessage() {
        return phoneErrorMessage.shouldBe(Condition.visible).getText();
    }

    public static String getPasswordErrorMessage() {
        return passwordErrorMessage.shouldBe(Condition.visible).getText();
    }

    public static void clickAuthLoginButton() {
        authLoginButton.shouldBe(Condition.interactable).click();
    }

    public static CatalogPopularPage searchByKeyWord(String keyWord) {
        searchInput.shouldBe(Condition.visible).setValue(keyWord).shouldBe(Condition.visible).pressEnter();
        return new CatalogPopularPage();
    }



}
