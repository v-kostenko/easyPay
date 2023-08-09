package web.pageObjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class TopUpMobilePage {
    public static SelenideElement amountField = $x("//input[@input-decimal='2']");

}
