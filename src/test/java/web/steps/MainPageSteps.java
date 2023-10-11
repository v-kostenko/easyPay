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
        return headerTransfersLink.shouldBe(visible).isDisplayed();
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
        mainPageTopUpMobileSubmitButton.shouldBe(visible).click();

//        int counter = 0;
//        do{
//            mainPageTopUpMobileSubmitButton.shouldBe(visible).click();
//            Thread.sleep(1000);
//            counter++; // перепроверить
//            if (counter == 5) {
//                break;
//            }
//        } while (topUpMobileHeader.isDisplayed());

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
        headerTransfersLink.shouldBe(visible).click();
    }

    @Step("Cvv validation error message")
    public static String getCvvValidationErrorMessage() {
        return mainPageCvvValidationErrorMessage.shouldBe(visible).getText();
    }

    @Step("Get receipt error message")
    public static String getReceiptErrorMessage(){
        return blockErrorReceipt.shouldBe(visible).getText();
    }

    @Step("Click on the 'Download' receipt button")
    public static void clickOnTheDownloadReceiptButton(){
        downloadReceiptButton.shouldBe(visible).click();
    }

    @Step("Get error message for 'TransactionId' field")
    public static String getErrorMessageForTransactionIdField(){
       return receiptErrorMessageForTransactionIdField.shouldBe(visible).getText();
    }

    @Step("Get error message for 'Amount' field")
    public static String getErrorMessageForAmountField(){
        return receiptErrorMessageForAmountField.shouldBe(visible).getText();
    }

    @Step("Input payment ID")
    public static void inputPaymentId(String paymentId){
        receiptInputPaymentIdField.shouldBe(visible).setValue(paymentId);
    }

    @Step("Input amount ID")
    public static void inputAmount(String amount){
        receiptInputAmountField.shouldBe(visible).setValue(amount);
    }






}
