package web.pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    public static SelenideElement
            headerLoginButton = $x("//button[contains(@class,'header__sign-in')]"),
            headerSignUpButton = $x("//button[contains(@class,'header__sign-up button')]"),
            loginFormTitle = $x("//h2[contains(@class,'log-in_title show-for-large')]"),
            phoneInput = $x("//input[contains(@class,'phone-field_input')]"),
            passwordInput = $x("//input[@name='password']"),
            authLoginButton = $x("//div[@class='auth-button_block']//button"),
            authRegistrationLink = $x("//a[contains(@class,'registration-link')]"),
            phoneErrorMessage = $x("//div[contains(@class,'phone-field-pb')]//div[@class='ng-star-inserted']"),
            passwordErrorMessage = $x("//div[contains(@class,'mat-form-field')]//div[@class='ng-star-inserted']"),
            forgotPasswordLink = $x("//div[contains(@class,'restore__link')]/a"),
            searchInput = $x("//input[@id='search']");

    public AuthRegisterPage clickHeaderSignUpButton() {
        headerSignUpButton.click();
        return new AuthRegisterPage();
    }

    public AuthRestorePage clickForgotPasswordLink() {
        forgotPasswordLink.click();
        return new AuthRestorePage();
    }

    public AuthRegisterPage clickAuthRegistrationLink() {
        authRegistrationLink.click();
        return new AuthRegisterPage();
    }



}
