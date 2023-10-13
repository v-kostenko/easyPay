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
        Configuration.timeout = 7000;
         Configuration.browser = "chrome";
         // setBrowser();
         Configuration.baseUrl = "https://easypay.ua/ua";
        // setEnv();
        //Configuration.browserSize = "1920x1000";
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
        String environment = System.getProperty("env", "prod");

        if (Objects.equals(environment, "prod")) {
            Configuration.baseUrl = "https://easypay.ua/ua";
        } else if (Objects.equals(environment, "dev")) {
            Configuration.baseUrl = "https://dev.easypay.ua/ua";
        } else {
            Configuration.baseUrl = "https://stage.easypay.ua/ua";
        }
    }


}
