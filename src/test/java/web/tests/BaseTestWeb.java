package web.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public abstract class BaseTestWeb {

    @BeforeAll
    public static void set(){
        Configuration.timeout = 10000;
        Configuration.browser = "firefox";
        Configuration.baseUrl = "https://easypay.ua/ua";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true) );
    }

    @BeforeEach
    public void setUp(){
        open("/");
    }

    @AfterEach
    public void tearDown(){
        Selenide.closeWebDriver();
    }


}
