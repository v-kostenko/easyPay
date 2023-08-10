package web.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;


import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static web.constants.Constants.*;
import static web.pageObjects.PaymentsPage.getProfileHeaderTitleOnPaymentsPage;
import static web.steps.LoginSteps.*;
import static web.steps.RegistrationSteps.getRegistrationPageHeader;
import static web.steps.RestoreSteps.getRestorePageHeader;

@Tag("web")
@Tag("smoke")
@Tag("regression")
@Tag("login")
public class LoginTests extends BaseTestWeb {
    @BeforeEach
    public void setUpPath() {
        open("/");
    }

    @Test
    @DisplayName("Success login")
    @Description("Try to login with valid cred")
    @Owner("Volodymyr Kostenko")
    @Severity(SeverityLevel.CRITICAL)
    public void loginWithValidCred() {
        successLogin(PHONE, PASSWORD);
        step("Check that we got the PaymentsPage", () -> {
            Assertions.assertEquals(PAYMENT_TITLE, getProfileHeaderTitleOnPaymentsPage(), "Don't find Payment page title");
        });
    }

    @Test
    @DisplayName("Login with wrong password. Check error message")
    @Owner("Volodymyr Kostenko")
    public void loginWithWrongPassword() {
        clickHeaderLoginButton();
        inputPhone(PHONE);
        inputPassword("xxx");
        clickAuthLoginButton();
        step("Check that we got error message", () -> {
            Assertions.assertEquals(WRONG_PASSWORD_ERROR_MESSAGE, getWrongPasswordErrorMessage());
        });
    }

    @Test
    @DisplayName("Input wrong phone format. Check error message")
    @Owner("Volodymyr Kostenko")
    public void inputPhoneWrongFormat() {
        clickHeaderLoginButton();
        inputPhone("6600514");
        clickAuthLoginButton();
        step("Check error messages for phone field and password field", () -> {
            Assertions.assertEquals(PHONE_FIELD_WRONG_FORMAT_ERROR_MESSAGE, getPhoneErrorMessage().trim());
        });
    }

    @Test
    @DisplayName("Check error messages for 'Phone' and 'Password' fields")
    @Description("Don't fill 'phone' and 'password' fields. Click 'Login' button")
    @Owner("Volodymyr Kostenko")
    @Severity(SeverityLevel.NORMAL)
    public void checkErrorMessagesForPhoneAndPasswordFields() {
        clickHeaderLoginButton();
        clickAuthLoginButton();
        step("Check error messages for phone field and password field", () -> {
            Assertions.assertEquals(PHONE_FIELD_MANDATORY_ERROR_MESSAGE, getPhoneErrorMessage());
            Assertions.assertEquals(PASSWORD_FIELD_ERROR_MESSAGE, getPasswordErrorMessage());
        });
    }

    @Test
    @DisplayName("Check that 'ForgotPasswordLink' redirect to AuthRestorePage")
    @Owner(value = "Volodymyr Kostenko")
    public void checkRedirectForgotPasswordLink() {
        clickHeaderLoginButton();
        clickForgotPasswordLink();
        step("Check RestorePage header", () -> {
            Assertions.assertEquals(RESTORE_PAGE_HEADER, getRestorePageHeader());
        });
    }

    @Test
    @DisplayName("Check that 'RegisterLink' redirect to AuthRegisterPage")
    @Owner("Volodymyr Kostenko")
    public void checkRedirectRegisterLink() {
        clickHeaderLoginButton();
        clickAuthRegistrationLink();
        step("Check that RegisterPage URL ends with '/auth/register'", () -> {
            Assertions.assertEquals(REGISTER_PAGE_HEADER, getRegistrationPageHeader());
        });
    }

    @Test
    public void checkGoogleAuth() {
        clickHeaderLoginButton();
        clickGoogleAuthButton();
        // Що тут перевірити? Відкривається сторінка Гугл.
    }


}
