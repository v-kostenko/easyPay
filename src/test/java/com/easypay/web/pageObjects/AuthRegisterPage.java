package com.easypay.web.pageObjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class AuthRegisterPage {
    public static SelenideElement registrationHeader = $x("//h1[@class='ng-star-inserted']");
    public static SelenideElement registrationPhoneField = $x("//form[contains(@class,'registration_phone')]//input[contains(@class,'auth-input')]");
    public static SelenideElement registrationRegisterButton = $x("//form[contains(@class,'registration_phone')]//button[contains(@class,'auth-button')]");
    public static SelenideElement registrationErrorMessage = $x("//form[contains(@class,'registration_phone')]//span[contains(@class,'field-error')]");
    public static SelenideElement registrationPhonePrefix = $x("//form[contains(@class,'registration_phone')]//span[contains(@class,'phone-field_prefix-code')]");

}
