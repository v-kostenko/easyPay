package web.pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    public static SelenideElement headerLoginButton = $x("//button[contains(@class,'header__sign-in')]");
    public static SelenideElement headerSignUpButton = $x("//button[contains(@class,'header__sign-up button')]");
    public static SelenideElement loginFormTitle = $x("//h2[contains(@class,'log-in_title show-for-large')]");
    public static SelenideElement phoneInput = $x("//input[contains(@class,'phone-field_input')]");
    public static SelenideElement passwordInput = $x("//input[@name='password']");
    public static SelenideElement authLoginButton = $x("//div[@class='auth-button_block']//button");
    public static SelenideElement authRegistrationLink = $x("//a[contains(@class,'registration-link')]");
    public static SelenideElement phoneFieldErrorMessage = $x("//div[contains(@class,'phone-field-pb')]//div[@class='ng-star-inserted']");
    public static SelenideElement passwordFieldErrorMessage = $x("//div[contains(@class,'mat-form-field')]//div[@class='ng-star-inserted']");
    public static SelenideElement forgotPasswordLink = $x("//div[contains(@class,'restore__link')]/a");
    public static SelenideElement googleAuthButton = $x("//button[contains(@class,'google-auth-btn')]");

    public static SelenideElement searchInput = $x("//input[@id='search']");
    public static SelenideElement wrongPasswordErrorMessage = $x("//div[contains(@class,'block-error')]");
    public static SelenideElement transferMoneyButton = $x("//button[@id='c2c-home-unique']");
    public static SelenideElement headerLogo = $x("//div[contains(@class,'header_logo')]//img");
    public static ElementsCollection sideMenu = $$x("//ul[@class='sidemenu_navigation']//a");

    public static SelenideElement topUpMobileHeader = $x("//div[contains(@class,'mobile-topup')]//h2");
    public static SelenideElement topUpPhoneInput = $x("//input[@id='topup-phone']");
    public static SelenideElement topUpSubmitButton = $x("//button[@id='home-topup-unique']");
    public static SelenideElement topUpErrorMessage = $x("//div[contains(@class,'topup__phone')]//span[contains(@class,'field-error')]");


}
