package web.pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    public static SelenideElement headerLoginButton = $x("//button[contains(@class,'header__sign-in')]");
    public static SelenideElement headerSignUpButton = $x("//button[contains(@class,'header__sign-up button')]");
    public static SelenideElement loginFormTitle = $x("//h2[contains(@class,'log-in_title show-for-large')]");
    public static SelenideElement phoneInput = $x("//input[contains(@class,'phone-field_input')]");
    public static SelenideElement passwordInput = $x("//input[@name='password']");
    public static SelenideElement authLoginButton = $x("//div[@class='auth-button_block']//button");
    public static SelenideElement authRegistrationLink = $x("//a[contains(@class,'registration-link')]");
    public static SelenideElement phoneErrorMessage = $x("//div[contains(@class,'phone-field-pb')]//div[@class='ng-star-inserted']");
    public static SelenideElement passwordErrorMessage = $x("//div[contains(@class,'mat-form-field')]//div[@class='ng-star-inserted']");
    public static SelenideElement forgotPasswordLink = $x("//div[contains(@class,'restore__link')]/a");
    public static SelenideElement searchInput = $x("//input[@id='search']");


    public static PaymentsPage successLogin(String phone, String password) {
        headerLoginButton.shouldBe(Condition.visible).click();
        phoneInput.shouldBe(Condition.visible).setValue(phone);
        passwordInput.shouldBe(Condition.visible).setValue(password);
        authLoginButton.click();
        return new PaymentsPage();
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

    public static CatalogPopularPage searchByKeyWord(String keyWord) {
        searchInput.shouldBe(Condition.visible).setValue(keyWord).shouldBe(Condition.visible).pressEnter();
        return new CatalogPopularPage();
    }

}
