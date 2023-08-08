package web.tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class RegistrationTest extends BaseTestWeb{

    @BeforeEach
    public void setUpPath(){
        open("/auth/register");
    }

    @Test
    @Disabled
    @DisplayName("Check all elements presence")
    @Owner("Volodymyr Kostenko")
    public void checkAllElementsPresence(){
        // перевірити всі елементи
    }





}
