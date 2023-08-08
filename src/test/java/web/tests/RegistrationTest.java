package web.tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static web.constants.Constants.PHONE_FIELD_ERROR_MESSAGE;
import static web.constants.Constants.PHONE_FIELD_WRONG_FORMAT_ERROR_MESSAGE;
import static web.steps.RegistrationSteps.*;

public class RegistrationTest extends BaseTestWeb {

    @BeforeEach
    public void setUpPath() {
        open("/auth/register");
    }

    @Test
    @Disabled
    @DisplayName("Check all elements presence")
    @Owner("Volodymyr Kostenko")
    public void checkAllElementsPresence() {
        // перевірити присутність всіх елементів
    }

    @Test
    @DisplayName("Check mandatory to completion error message")
    @Owner("Volodymyr Kostenko")
    public void checkMandatoryToCompletionErrorMessage() {
        clickOnTheInputField();
        clickOnThePhonePrefix();
        step("Check error message", () -> {
            Assertions.assertEquals(PHONE_FIELD_ERROR_MESSAGE, getErrorMessageText());
        });
    }

    @Test
    @DisplayName("Check doesn't meet the rule error message")
    @Owner("Volodymyr Kostenko")
    public void checkDoesntMeetTheRuleErrorMessage() {
        inputPhoneNumber("111");
        clickOnThePhonePrefix();
        step("Check error message", () -> {
            Assertions.assertEquals(PHONE_FIELD_WRONG_FORMAT_ERROR_MESSAGE, getErrorMessageText());
        });
    }

    @Test
    @Owner("Volodymyr Kostenko")
    public void registeredUser() {
        // В полее ввода номера телефона ввести номер, который ранее был зарегистирован
        // Кликнуть на кнопку "Зарегистироваться"
        // Открылась страница авторизации
    }


    @Test
    public void bbb() {
        // Открыть страницу регистрации и ввести не полный номер телефона
        // Кнопка "Зарегистироваться" не активна
    }


}
