package web.pageObjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class TopUpMobilePage {
    public static SelenideElement amountField = $x("//input[@input-decimal='2']");
    public static SelenideElement serviceHeroName = $x("//div[contains(@class,'services_hero-name')]//h1");
    public static SelenideElement fieldError = $x("//span[contains(@class,'field-error')]");
    public static SelenideElement topUpMobilePageSubmitButton = $x("//div[contains(@class,'form-row')]/button");
}
