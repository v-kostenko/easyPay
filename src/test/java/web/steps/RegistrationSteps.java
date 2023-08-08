package web.steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static web.pageObjects.AuthRegisterPage.*;

public class RegistrationSteps {

    @Step("Click on the 'Input phone field'")
    public static void clickOnTheInputField() {
        registrationPhoneField.shouldBe(Condition.visible).click();
    }

    @Step("Click on the 'Registration button'")
    public static void clickOnTheRegistrationButton() {
        registrationRegisterButton.click();
    }

    @Step("Click on the phone prefix")
    public static void clickOnThePhonePrefix() {
        registrationPhonePrefix.click();
    }

    @Step("Get error message text")
    public static String getErrorMessageText() {
        return registrationErrorMessage.shouldBe(Condition.visible).getText();
    }

    @Step("Input phone")
    public static void inputPhoneNumber(String phone){
        registrationPhoneField.shouldBe(Condition.visible).setValue(phone);
    }


}
