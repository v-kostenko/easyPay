package com.easypay.web.pageObjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class PaymentPage {
    public static SelenideElement cardNumber = $x("//div[contains(@class,'mat-form-field-infix')]//input[contains(@class,'pay-tool_pan-input')]");
    public static SelenideElement cardExpire = $x("//div[contains(@class,'mat-form-field-infix')]//input[@name='card-expire']");
    public static SelenideElement cvvInput = $x("//div[contains(@class,'mat-form-field-infix')]//input[contains(@class,'pay-tool_cvv-input')]");
    public static SelenideElement paySubmitButton = $x("//div[contains(@class,'x-pay-tool__submit')]//button");

}
