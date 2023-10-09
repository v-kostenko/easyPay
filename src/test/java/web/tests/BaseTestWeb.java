package web.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.open;

public abstract class BaseTestWeb {

    @BeforeAll
    public static void setUp() {
        // Configuration.headless = true; // true - Не открывать физически браузер
        Configuration.timeout = 15000;
        // Configuration.browser = "firefox";
        setBrowser();
         // Configuration.baseUrl = "https://easypay.ua/ua";
        setEnv();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }


    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    private static void setBrowser() {
        if (!Objects.equals(System.getProperty("browser", "chrome"), "chrome")) {
            Configuration.browser = "firefox";
        } else {
            Configuration.browser = "chrome";
        }
    }

    private static void setEnv() {
        String envirment = System.getProperty("env","prod");

        if (Objects.equals(envirment, "prod")) {
            Configuration.baseUrl = "https://easypay.ua/ua";
        } else if (Objects.equals(envirment, "dev")) {
            Configuration.baseUrl = "https://dev.easypay.ua/ua";
        } else {
            Configuration.baseUrl = "https://stage.easypay.ua/ua";
        }
    }


}
