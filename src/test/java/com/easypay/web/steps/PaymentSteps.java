package com.easypay.web.steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.easypay.web.pageObjects.PaymentPage.*;

public class PaymentSteps {

    @Step("Input card number")
    public static void inputCardNumber(String bankCardNumber) {
        cardNumber.shouldBe(Condition.visible).setValue(bankCardNumber);
    }

    @Step("Input expire date")
    public static void inputExpireDate(String expDate) {
        cardExpire.shouldBe(Condition.visible).setValue(expDate);
    }

    @Step("Input cvv")
    public static void inputCvv(String cvv) {
        cvvInput.shouldBe(Condition.visible).setValue(cvv);
    }

    @Step("Click 'Pay submit' button")
    public static void clickPaySubmitButton() {
        paySubmitButton.shouldBe(Condition.visible).click();
    }


}
