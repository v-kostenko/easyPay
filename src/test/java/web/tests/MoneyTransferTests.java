package web.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import web.pageObjects.MainPage;
import web.pageObjects.MoneyTransferPage;
import web.pageObjects.PaymentsPage;
import web.pageObjects.Transfer2CardPage;

import static web.constants.Constants.*;

@Tag("web")
@Tag("regression")
public class MoneyTransferTests extends BaseTestWeb {

    @Test
    @DisplayName("Transfer2Card. Check bank logo")
    @Description("Add new feature to the transfer2card. Display bank logo after input card number.")
    @Owner("Volodymyr Kostenko")
    @Severity(SeverityLevel.MINOR)
    @Issue("EF-575")
    public void checkBankLogo() throws InterruptedException {
        MainPage mainPage = new MainPage();
        PaymentsPage paymentsPage = mainPage.successLogin(PHONE, PASSWORD);
        MoneyTransferPage moneyTransferPage = paymentsPage.clickTransferLink();
        Transfer2CardPage transfer2CardPage = moneyTransferPage.clickTransfer2CardLink();
        Thread.sleep(2000); // Тест проходит только после того как поставил Thread.sleep. Как можно это решить без этого костыля?
        transfer2CardPage.inputCardNumber(CARD_NUMBER);
        Assertions.assertTrue(transfer2CardPage.isBankLogoPresent());
    }


}