package web.steps;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static web.pageObjects.MainPage.headerLogo;
import static web.pageObjects.MainPage.transferMoneyButton;

public class MainPageSteps {

    @Step("Click money transfer money")
    public static void clickTransferMoneyButton() {
//        while(! ){
//
//        }
        transferMoneyButton.shouldBe(visible).click();
    }

    @Step("Check that header logo is displayed")
    public static boolean isHeaderLogoDisplayed() {
        return headerLogo.shouldBe(visible).isDisplayed();
    }


}
