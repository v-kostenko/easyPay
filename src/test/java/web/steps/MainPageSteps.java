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

    @Step("Check that 'Transfers link' is displayed")
    public static boolean isTransfersLinkDisplayed() {
        return transfersLink.shouldBe(visible).isDisplayed();
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
    public static void clickTopUpSubmitButton() throws InterruptedException {
        int counter = 0;
        do{
            mainPageTopUpMobileSubmitButton.shouldBe(visible).click();
            Thread.sleep(1000);
            counter++; // перепроверить
            if (counter == 5) {
                break;
            }
        } while (topUpMobileHeader.isDisplayed());

//        while (topUpMobileHeader.isDisplayed()) {
//            mainPageTopUpMobileSubmitButton.shouldBe(visible).click();
//            counter++; // перепроверить
//            if (counter == 5) {
//                break;
//            }
//        }
    }

    @Step("Click to transfers link")
    public static void clickToTransfersLink() {
        transfersLink.shouldBe(visible).click();
    }


}
