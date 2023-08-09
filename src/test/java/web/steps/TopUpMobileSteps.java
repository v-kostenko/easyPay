package web.steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static web.pageObjects.MainPage.topUpErrorMessage;
import static web.pageObjects.TopUpMobilePage.amountField;

public class TopUpMobileSteps {

    @Step("Input amount to top-up mobile field")
    public static void inputAmountToTopUpMobileField(String amount) {
        amountField.shouldBe(Condition.visible).setValue(amount);
    }

    @Step("Top-Up mobile. Get error message")
    public static String getTopUpPhoneFieldErrorMessage() {
        return topUpErrorMessage.shouldBe(Condition.visible).getText();
    }


}
