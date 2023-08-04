package web.steps;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static web.pageObjects.MainPage.transferMoneyButton;

public class MainPageSteps {

    @Step("Click money transfer money")
    public static void clickTransferMoneyButton() {
        transferMoneyButton.shouldBe(visible).click();
    }


}
