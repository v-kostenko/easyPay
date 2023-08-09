package web.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;


import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static web.constants.Constants.*;
import static web.pageObjects.MainPage.sideMenu;
import static web.steps.MainPageSteps.*;
import static web.steps.TopUpMobileSteps.getTopUpPhoneFieldErrorMessage;


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
    @DisplayName("Check error messages c2c transfer money")
    @Owner("Volodymyr Kostenko")
    public void checkErrorMessagesC2CTransferMoney() {
        clickTransferMoneyButton();
        // Check all error messages
    }

    @Test
    @DisplayName("Check presence all elements on the page")
    @Owner("Volodymyr Kostenko")
    public void checkAllElementsPresence() {
        Assertions.assertTrue(isHeaderLogoDisplayed());
        // catalog is present
        // transfer is present
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
    @DisplayName("Check It is not in compliance with the rule")
    @Owner("Volodymyr Kostenko")
    public void topUpMobileCheckIsNotComplianceWithTheRuleErrorMessage() {
        Assertions.assertEquals(TOP_UP_MOBILE_HEADER, getTopUpMobileHeader());
        inputPhoneForTopUp(PHONE.replaceAll("[0]", ""));
        clickTopUpSubmitButton();
        step("Check error message", () -> {
            Assertions.assertEquals(PHONE_FIELD_WRONG_FORMAT_ERROR_MESSAGE, getTopUpPhoneFieldErrorMessage());
        });
    }

    @Test
    @DisplayName("Check mobile top-up mandatory for completion error message")
    public void topUpMobileCheckMandatoryErrorMessage() {
        clickTopUpSubmitButton();
        step("Check error message", () -> {
            Assertions.assertEquals(PHONE_FIELD_MANDATORY_ERROR_MESSAGE, getTopUpPhoneFieldErrorMessage());
        });
    }


}
