package web.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static io.qameta.allure.Allure.step;
import static web.constants.Constants.MAIN_PAGE_TITLE;
import static web.steps.MainPageSteps.clickTransferMoneyButton;
import static web.steps.MainPageSteps.isHeaderLogoDisplayed;

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
        // Check other elements
    }


}
