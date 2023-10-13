package web.tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;


import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static web.constants.Constants.*;
import static web.pageObjects.MainPage.sideMenu;
import static web.pageObjects.SuccessAfterPaymentPage.successAfterPaymentTitle;
import static web.pageObjects.TopUpMobilePage.*;
import static web.steps.MainPageSteps.*;
import static web.steps.PaymentSteps.*;
import static web.steps.TopUpMobileSteps.*;


@Tag(value = "web")
public class MainPageTests extends BaseTestWeb {

    @BeforeEach
    public void setUpPath() {
        open("/");
    }

    @Test
    @DisplayName("Check main page title UA language")
    @Description("This test checks main page title UA language")
    @Owner("Volodymyr Kostenko")
    @Severity(SeverityLevel.MINOR)
    public void checkPageTitle() {
        step("Check main page title", () -> {
            Assertions.assertEquals(MAIN_PAGE_TITLE, title(), "Actual and expected title are different");
        });
    }

    @Test
    @DisplayName("Check presence off all elements on the page")
    @Owner("Volodymyr Kostenko")
    public void checkAllElementsPresence() {
        Assertions.assertTrue(isHeaderLogoDisplayed());
        Assertions.assertTrue(isTransfersLinkDisplayed());
        // language is present
        //
    }

    @Test
    @DisplayName("Check side-menu size")
    @Owner("Volodymyr Kostenko")
    public void checkSideMenuSize() {
        Assertions.assertEquals(20, sideMenu.size());
    }

    @Test
    @DisplayName("Open all links from side menu and check URL")
    @Owner("Volodymyr Kostenko")
    public void openAllLinksFromSideMenuAndCheckUrl() {
        List<String> links = new ArrayList<>();
        for (SelenideElement element : sideMenu) {
            links.add(element.getAttribute("href"));
        }

        for (int i = 0; i < links.size(); i++) {
            String url = links.get(i);
            Selenide.open(url);
            String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
            Assertions.assertEquals(url, currentUrl);
            // проверить статус код (АРІ )
        }
    }


    //    ----------- TOP-UP MOBILE FROM MAIN PAGE ------------------
    @Test
    @DisplayName("Check It is not in compliance with the rule")
    @Owner("Volodymyr Kostenko")
    public void topUpMobileCheckIsNotComplianceWithTheRuleErrorMessage() throws InterruptedException {
        Assertions.assertEquals(TOP_UP_MOBILE_HEADER, getTopUpMobileHeader());
        inputPhoneForTopUp(PHONE.replaceAll("[0]", ""));
        clickTopUpSubmitButton();
        step("Check error message", () -> {
            Assertions.assertEquals(PHONE_FIELD_WRONG_FORMAT_ERROR_MESSAGE, getTopUpPhoneFieldErrorMessage());
        });
    }

    @Test
    @DisplayName("Check mobile top-up mandatory for completion error message")
    @Owner("Volodymyr Kostenko")
    public void topUpMobileCheckMandatoryErrorMessage() throws InterruptedException {
        Thread.sleep(1500);
        clickTopUpSubmitButton();
        step("Check error message", () -> {
            Assertions.assertEquals(REGISTER_PAGE_PHONE_FIELD_MANDATORY_ERROR_MESSAGE, getTopUpPhoneFieldErrorMessage());
        });
    }

    @Test
    @DisplayName("Try to top-up mobile less than 1 ua")
    @Owner("Volodymyr Kostenko")
    public void topUpMobileInputLessThanOneUaToAmountField() throws InterruptedException {
        inputPhoneForTopUp("80958872559");
        Thread.sleep(2000);
        clickTopUpSubmitButton();
        Thread.sleep(2000);
        inputAmountToTopUpMobileField("0.99");
        step("Click somewhere to get error message", () -> {
            topUpMobileServiceHeroName.click();
        });
        step("Check error message and state 'Submit' button", () -> {
            Assertions.assertEquals(TOP_UP_MOBILE_MORE_THAN_1_UA_ERROR_MESSAGE, getTopUpPhoneFieldErrorMessage());
            Assertions.assertFalse(isTopUpMobilePageSubmitButtonEnable());
        });
    }

    @Test
    @DisplayName("Try to top-up mobile with 4 999.99 UA. Unlogged user.")
    @Owner("Volodymyr Kostenko")
    public void topUpMobileInput4999_99UaToAmountField() throws InterruptedException {
        inputPhoneForTopUp("80958872559");
        Thread.sleep(2000);
        clickTopUpSubmitButton();
        Thread.sleep(2000);
        inputAmountToTopUpMobileField("4999.99");
        step("Click somewhere to get error message", () -> {
            topUpMobileServiceHeroName.click();
        });
        step("Check state 'Submit' button (Enable).", () -> {
            Assertions.assertTrue(isTopUpMobilePageSubmitButtonEnable());
        });
    }

    @Test
    @DisplayName("Try to top-up mobile more than 4 999.99 UA. Unlogged user.")
    @Owner("Volodymyr Kostenko")
    public void topUpMobileInputMoreThan4999UaToAmountField() throws InterruptedException {
        inputPhoneForTopUp("80958872559");
        Thread.sleep(2000);
        clickTopUpSubmitButton();
        Thread.sleep(2000);
        inputAmountToTopUpMobileField("5000");
        step("Click somewhere to get error message", () -> {
            topUpMobileServiceHeroName.click();
        });
        step("Check error message and state 'Submit' button", () -> {
            Assertions.assertEquals(TOP_UP_MOBILE_LESS_THAN_4999_99_UA_ERROR_MESSAGE, getTopUpPhoneFieldErrorMessage());
            Assertions.assertFalse(isTopUpMobilePageSubmitButtonEnable());
        });
    }

    @Test
    @DisplayName("Check all elements presence on the top-up mobile page")
    @Owner("Volodymyr Kostenko")
    public void topUpMobilePageCheckPresenceOfAllElements() throws InterruptedException {
        inputPhoneForTopUp("80958872559");
        Thread.sleep(2000);
        clickTopUpSubmitButton();

        Assertions.assertEquals(TOP_UP_MOBILE_PAGE_MAT_HINT, getTopUpMobilePageMatHintText());
        step("Check that top-up mobile service icon is displayed", () -> {
            Assertions.assertTrue(topUpMobileServiceIcon.isDisplayed());
        });
        step("Check that service title is displayed", () -> {
            Assertions.assertTrue(topUpMobileServiceTitle.getText().startsWith("Поповнення рахунку"));
        });
        step("Check advice default title", () -> {
            Assertions.assertEquals(ADVICE_DEFAULT_TITLE, topUpAdviceDefaultTitle.getText());
        });
        step("Check advice default text", () -> {
            Assertions.assertEquals(ADVICE_DEFAULT_TEXT, topUpAdviceDefaultText.getText());
        });
        step("Check add card text", () -> {
            Assertions.assertEquals(ADD_CARD_TEXT, topUpAdviceAddCardText.getText());
        });
        step("Check add advice create template text", () -> {
            Assertions.assertEquals(ADVICE_CREATE_TEMPLATE, topUpAdviceAdviceTemplateText.getText());
        });
        // Register icon
        // RegisterLink redirect
        // Add cart icon
        // create template icon
    }

    @Test
    @DisplayName("Success mobile top-up from main page")
    @Owner("Volodymyr Kostenko")
    @Disabled
    public void topUpMobileFromMainPage() throws InterruptedException {
        inputPhoneForTopUp("80660051447");
        Thread.sleep(2000);
        clickTopUpSubmitButton();

        inputAmountToTopUpMobileField("1");
        topUpMobilePageClickSubmitButton();

        inputCardNumber("");
        inputExpireDate("");
        inputCvv("");
        clickPaySubmitButton();

        step("Check that we got success page", () -> {
            Thread.sleep(10000);
            Assertions.assertEquals(SUCCESS_AFTER_MOBILE_TOP_UP, successAfterPaymentTitle.shouldBe(visible).getText());
        });
    }


    // --------- TRANSFER MONEY FROM MAIN PAGE -----------
    @Test
    @DisplayName("Check error messages c2c transfer money")
    @Owner("Volodymyr Kostenko")
    public void checkErrorMessagesC2CTransferMoney() throws InterruptedException {
        Thread.sleep(1500);
        clickTransferMoneyButton();
        Assertions.assertEquals(MAIN_PAGE_CVV_VALIDATION_ERROR_MESSAGE, getCvvValidationErrorMessage());
        // Check all error messages
    }


    // --------- Receipt ---------
    @Test
    @DisplayName("Check error messages for 'PaymentId' and 'Transaction amount' fields")
    @Description("Don't fill fields and click 'Download' button")
    public void checkReceiptErrorMessages() {
        clickOnTheDownloadReceiptButton();
        step("Check error messages for 'PaymentId' and 'Transaction amount' fields", () -> {
            Assertions.assertEquals(RECEIPT_FIELD_ERROR_MESSAGE_FOR_ID_AND_AMOUNT, getErrorMessageForTransactionIdField());
            Assertions.assertEquals(RECEIPT_FIELD_ERROR_MESSAGE_FOR_ID_AND_AMOUNT, getErrorMessageForAmountField());
        });
    }

    @Test
    @DisplayName("Input valid Payment ID and not valid amount")
    public void checkInvalidAmountErrorMessage() {
        inputPaymentId(PAYMENT_ID);
        inputAmount("222");
        clickOnTheDownloadReceiptButton();
        step("Check 'Invalid amount error message'", () -> {
            Assertions.assertEquals(INVALID_AMOUNT_ERROR_MESSAGE, getReceiptErrorMessage());
        });
    }

    @Test
    @DisplayName("Input invalid Payment ID and valid amount")
    public void checkInvalidPaymentIdErrorMessage() {
        inputPaymentId(PAYMENT_ID + "12");
        inputAmount("3");
        clickOnTheDownloadReceiptButton();
        step("Check 'Invalid amount error message'", () -> {
            Assertions.assertEquals(INVALID_PAYMENT_ID_ERROR_MESSAGE, getReceiptErrorMessage());
        });
    }


}
