package com.easypay.web.pageObjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SuccessAfterPaymentPage {
    public static SelenideElement successAfterPaymentTitle = $x("//section[@class='payment-final_block']//p[@class='title']");
    public static SelenideElement downloadButton = $x("//button[@class='download-btn']");
    public static SelenideElement emailInput = $x("//input[@type='email']");
    public static SelenideElement sendEmailButton = $x("//button[contains(@class,'payment-final_send-btn')]");

}
