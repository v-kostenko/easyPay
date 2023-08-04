package web.tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static io.qameta.allure.Allure.step;
import static web.constants.Constants.MAIN_PAGE_TITLE;
import static web.pageObjects.MainPage.transferMoneyButton;
import static web.steps.MainPageSteps.clickTransferMoneyButton;

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
            Assertions.assertEquals(title(), MAIN_PAGE_TITLE, "Actual and expected title are different");
        });
    }

    @Test
    @DisplayName("Check error messages c2c transfer money")
    @Owner("Volodymyr Kostenko")
    public void checkErrorMessagesC2CTransferMoney() {
        clickTransferMoneyButton();
    }


}
