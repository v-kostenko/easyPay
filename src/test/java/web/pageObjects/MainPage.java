package web.pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    public static SelenideElement
            headerLoginButton = $x("//button[contains(@class,'header__sign-in')]"),
            headerSignUpButton = $x("//button[contains(@class,'header__sign-up button')]"),
            loginFormTitle = $x("//h2[contains(@class,'log-in_title show-for-large')]"),
            phoneInput = $x("//input[contains(@class,'phone-field_input')]"),
            passwordInput = $x("//input[@name='password']"),
            authLoginButton = $x("//div[@class='auth-button_block']//button"),
            authRegistrationLink = $x("//a[contains(@class,'registration-link')]"),
            phoneFieldErrorMessage = $x("//div[contains(@class,'phone-field-pb')]//div[@class='ng-star-inserted']"),
            passwordFieldErrorMessage = $x("//div[contains(@class,'mat-form-field')]//div[@class='ng-star-inserted']"),
            forgotPasswordLink = $x("//div[contains(@class,'restore__link')]/a"),
            searchInput = $x("//input[@id='search']"),
            wrongPasswordErrorMessage = $x("//div[contains(@class,'block-error')]"),
            transferMoneyButton = $x("//button[@id='c2c-home-unique']");




    public static ElementsCollection sideMenu = $$x("//div[@class='sidemenu']//span");

    public AuthRegisterPage clickHeaderSignUpButton() {
        headerSignUpButton.click();
        return new AuthRegisterPage();
    }


}
