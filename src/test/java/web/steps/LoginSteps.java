package web.steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import web.pageObjects.CatalogPopularPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static web.pageObjects.CatalogPopularPage.searchTagTitle;
import static web.pageObjects.MainPage.*;
import static web.pageObjects.PaymentsPage.profileHeaderTitle;

public class LoginSteps {

    @Step("Success login")
    public static void successLogin(String phone, String password) {
        clickHeaderLoginButton();
        phoneInput.shouldBe(visible).sendKeys(phone);
        passwordInput.shouldBe(visible).sendKeys(password);
        authLoginButton.click();
        profileHeaderTitle.shouldBe(visible, Duration.ofSeconds(30));
    }

    @Step("Input phone")
    public static void inputPhone(String phone) {
        phoneInput.shouldBe(visible).sendKeys(phone);
    }

    @Step("Input password")
    public static void inputPassword(String password) {
        passwordInput.shouldBe(visible).sendKeys(password);
    }

    @Step("Click header login button")
    public static void clickHeaderLoginButton() {
        int counter = 0;
        while (!loginFormTitle.isDisplayed()) {
            headerLoginButton.shouldBe(Condition.visible).click();
            counter++; // перепроверить
            if (counter == 5) {
                break;
            }
        }
    }

    @Step("Get login form title")
    public static String getLoginFormTitle() {
        return loginFormTitle.shouldBe(Condition.enabled).getText();
    }

    @Step("Get phone error message")
    public static String getPhoneErrorMessage() {
        return phoneFieldErrorMessage.shouldBe(Condition.visible).getText();
    }

    @Step("Get password error message")
    public static String getPasswordErrorMessage() {
        return passwordFieldErrorMessage.shouldBe(Condition.visible).getText();
    }

    @Step("Click auth login button")
    public static void clickAuthLoginButton() {
        authLoginButton.shouldBe(Condition.interactable).click();
    }

    @Step("Click forgot password link on login form")
    public static void clickForgotPasswordLink() {
        forgotPasswordLink.shouldBe(visible).click();
    }

    @Step("Click 'Registration' button on login for")
    public static void clickAuthRegistrationLink() {
        authRegistrationLink.click();
    }

    @Step("Get wrong password error message")
    public static String getWrongPasswordErrorMessage() {
        return wrongPasswordErrorMessage.shouldBe(visible).getText();
    }

    @Step("Click 'Google' auth button")
    public static void clickGoogleAuthButton() {
        googleAuthButton.shouldBe(visible).click();
    }


}
