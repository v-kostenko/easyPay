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

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static web.constants.Constants.*;
import static web.pageObjects.MainPage.sideMenu;
import static web.pageObjects.TopUpMobilePage.serviceHeroName;
import static web.steps.MainPageSteps.*;
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
        clickTopUpSubmitButton();
        step("Check error message", () -> {
            Assertions.assertEquals(PHONE_FIELD_MANDATORY_ERROR_MESSAGE, getTopUpPhoneFieldErrorMessage());
        });
    }

    @Test
    @DisplayName("Check not compliance with the rule error message")
    @Owner("Volodymyr Kostenko")
    public void topUpMobileCheckNotComplianceWithTheRule() throws InterruptedException {
        inputPhoneForTopUp("8066005");
        clickTopUpSubmitButton();
        step("Check error message", () -> {
            Assertions.assertEquals(PHONE_FIELD_WRONG_FORMAT_ERROR_MESSAGE, getTopUpPhoneFieldErrorMessage());
        });
    }

    @Test
    @DisplayName("Try to top-up mobile less than 1 ua")
    @Owner("Volodymyr Kostenko")
    public void topUpMobileInputLessThanOneUaToAmountField() throws InterruptedException {
        inputPhoneForTopUp("80958872559");
        Thread.sleep(2000);
        clickTopUpSubmitButton();
        inputAmountToTopUpMobileField("0");
        step("Click somewhere to get error message", () -> {
            serviceHeroName.click();
        });
        step("Check error message and state 'Submit' button", () -> {
            Assertions.assertEquals(TOP_UP_MOBILE_MORE_THAN_1_UA_ERROR_MESSAGE, getTopUpPhoneFieldErrorMessage());
            Assertions.assertFalse(isTopUpMobilePageSubmitButtonEnable());
        });
    }

    @Test
    @DisplayName("Try to top-up mobile more than 4 999.99 UA")
    @Owner("Volodymyr Kostenko")
    public void topUpMobileInputMoreThan4999UaToAmountField() throws InterruptedException {
        inputPhoneForTopUp("80958872559");
        Thread.sleep(2000);
        clickTopUpSubmitButton();
        inputAmountToTopUpMobileField("5000");
        step("Click somewhere to get error message", () -> {
            serviceHeroName.click();
        });
        step("Check error message and state 'Submit' button", () -> {
            Assertions.assertEquals(TOP_UP_MOBILE_LESS_THAN_4999_99_UA_ERROR_MESSAGE, getTopUpPhoneFieldErrorMessage());
            Assertions.assertFalse(isTopUpMobilePageSubmitButtonEnable());
        });
    }


    // --------- TRANSFER MONEY FROM MAIN PAGE -----------

    @Test
    @DisplayName("Check error messages c2c transfer money")
    @Owner("Volodymyr Kostenko")
    public void checkErrorMessagesC2CTransferMoney() {
        clickTransferMoneyButton();
        // Check all error messages
    }


}
