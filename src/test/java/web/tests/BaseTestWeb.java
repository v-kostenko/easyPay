package web.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.open;

public abstract class BaseTestWeb {

    @BeforeAll
    public static void setUp(){
        // Configuration.headless = true; // true - Не открывать физически браузер
        Configuration.timeout = 10000;
        Configuration.browser = "firefox";
        Configuration.baseUrl = "https://easypay.ua/ua";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }


    @AfterEach
    public void tearDown(){
        Selenide.closeWebDriver();
    }


}
