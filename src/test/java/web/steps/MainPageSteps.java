package web.steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static web.pageObjects.CatalogPopularPage.searchTagTitle;
import static web.pageObjects.MainPage.*;

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

    @Step("Search by IBAN")
    public static void searchByKeyWord(String keyWord) {
        while (!searchTagTitle.isDisplayed())
            searchInput.shouldBe(Condition.visible).setValue(keyWord).shouldBe(Condition.visible).pressEnter();
    }


}
