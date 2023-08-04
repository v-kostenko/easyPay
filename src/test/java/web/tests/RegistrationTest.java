package web.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class RegistrationTest extends BaseTestWeb{

    @BeforeEach
    public void setUpPath(){
        open("/auth/register");
    }

    @Test
    public void checkAllElementsPresence(){
        // всі елементи
    }





}
