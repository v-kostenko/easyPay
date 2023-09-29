package com.easypay.web.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.easypay.web.constants.Constants.*;
import static com.easypay.web.steps.LoginSteps.successLogin;

@Tag("web")
@Tag("regression")
public class MoneyTransferTests extends BaseTestWeb {

    @Test
    @DisplayName("Transfer2Card. Check bank logo")
    @Description("Add new feature to the transfer2card. Display bank logo after input card number.")
    @Owner("Volodymyr Kostenko")
    @Severity(SeverityLevel.MINOR)
    @Issue("EF-575")
    @Disabled
    public void checkBankLogo() throws InterruptedException {
        successLogin(PHONE, PASSWORD);
        // MoneyTransferPage moneyTransferPage = clickTransferLink();
        // Transfer2CardPage transfer2CardPage = moneyTransferPage.clickTransfer2CardLink();
        //  Thread.sleep(2000); // Тест проходит только после того как поставил Thread.sleep. Как можно это решить без этого костыля?
        //  transfer2CardPage.inputCardNumber(CARD_NUMBER);
        // transfer2CardPage.isBankLogoPresent();
        // icon.shouldBeVisible();
    }


}
