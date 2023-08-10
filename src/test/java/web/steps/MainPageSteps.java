package web.steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static web.pageObjects.CatalogPopularPage.searchTagTitle;
import static web.pageObjects.MainPage.*;

public class MainPageSteps {

    @Step("Click money transfer money")
    public static void clickTransferMoneyButton() {
        transferMoneyButton.shouldBe(visible).click();
    }

    @Step("Check that header logo is displayed")
    public static boolean isHeaderLogoDisplayed() {
        return headerLogo.shouldBe(visible).isDisplayed();
    }

    @Step("Search by IBAN")
    public static void searchByKeyWord(String keyWord) throws InterruptedException {
        while (!searchTagTitle.isDisplayed()) {
            searchInput.shouldBe(Condition.visible).setValue(keyWord).shouldBe(Condition.visible).pressEnter();
            Thread.sleep(500);
        }
    }

    @Step("Check top-up mobile header")
    public static String getTopUpMobileHeader() {
        return topUpMobileHeader.shouldBe(visible).getText();
    }

    @Step("Input phone for top-up")
    public static void inputPhoneForTopUp(String phone) {
        topUpPhoneInput.shouldBe(visible).setValue(phone);
    }

    @Step("Click top-up submit button")
    public static void clickTopUpSubmitButton() {
        topUpSubmitButton.shouldBe(visible).click();
        if (topUpMobileHeader.isDisplayed()) {
            topUpSubmitButton.shouldBe(visible).click();
        }
    }


}
