package web.steps;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static web.pageObjects.TopUpMobilePage.*;

public class TopUpMobileSteps {

    @Step("Input amount to top-up mobile field")
    public static void inputAmountToTopUpMobileField(String amount) {
        topUpMobileAmountField.shouldBe(visible).setValue(amount);
    }

    @Step("Top-Up mobile. Get error message")
    public static String getTopUpPhoneFieldErrorMessage() {
        return topUpMobileFieldError.shouldBe(visible).getText();
    }

    @Step("Get state submit button (Enable/Disable)")
    public static boolean isTopUpMobilePageSubmitButtonEnable() {
        return topUpMobilePageSubmitButton.isEnabled();
    }

    @Step("Get mat-hint text")
    public static String getTopUpMobilePageMatHintText() {
        return topUpMobilePageMatHint.shouldBe(visible).getText();
    }

    @Step("Click submit button on the top-up mobile page")
    public static void topUpMobilePageClickSubmitButton() {
        topUpMobilePageSubmitButton.shouldBe(visible).click();
    }

}
