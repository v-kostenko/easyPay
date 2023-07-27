package web.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import web.pageObjects.MainPage;

import static com.codeborne.selenide.Selenide.title;
import static io.qameta.allure.Allure.step;
import static web.constants.Constants.*;
import static web.pageObjects.MainPage.*;
import static web.pageObjects.PaymentsPage.getProfileHeaderTitleOnPaymentsPage;
import static web.utils.Helper.successLogin;

@Tag("web")
@Tag("smoke")
@Tag("regression")
@Tag("login")
public class LoginTests extends BaseTestWeb {

    @Test
    @DisplayName("Success login")
    @Description("Try to login with valid creds")
    @Owner("Volodymyr Kostenko")
    @Severity(SeverityLevel.CRITICAL)
    public void loginWithValidCred() {
        step("Click 'Login' button. Input correct phone and password. Click Login", () -> {
           successLogin(PHONE, PASSWORD);
        });
        step("Assert that login form has title.", () -> {
            Assertions.assertEquals(getLoginFormTitle(), LOGIN_FORM_TITLE, "");
        });
        step("Check that we got the PaymentsPage", () -> {
            Assertions.assertEquals(getProfileHeaderTitleOnPaymentsPage(), PAYMENT_TITLE, "");
        });
    }

    @Test
    @DisplayName("Check error messages loginWithEmptyFields")
    @Description("Check both error message phone and password fields")
    @Owner("Volodymyr Kostenko")
    @Severity(SeverityLevel.NORMAL)
    public void loginWithEmptyFields() {
        step("Click header login button", () -> {
            clickHeaderLoginButton();
        });
        step("Don't fill fields. Click Login button", () -> {
            clickAuthLoginButton();
        });
        step("Check error messages for phone field and password field", () -> {
            Assertions.assertEquals(getPhoneErrorMessage(), PHONE_ERROR_MESSAGE);
            Assertions.assertEquals(getPasswordErrorMessage(), PASSWORD_ERROR_MESSAGE);
        });
    }

//    @Test
//    @ParameterizedTest
//    @CsvFileSource(resources = "/test.csv")
//    public void tooo(String phone, String password){
//        MainPage mainPage = new MainPage();
//        mainPage.successLogin(phone, password);
//    }

    @Test
    @DisplayName("Check main page title UA language")
    @Description("This test checks main page title UA language")
    @Owner("Volodymyr Kostenko")
    @Severity(SeverityLevel.MINOR)
    public void checkTitle() {
        step("Check main page title", () -> {
            Assertions.assertEquals(title(), MAIN_PAGE_TITLE, "Actual and expected title are different");
        });
    }


}
