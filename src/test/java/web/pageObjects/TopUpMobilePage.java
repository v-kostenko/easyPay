package web.pageObjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class TopUpMobilePage {
    public static SelenideElement topUpMobileAmountField = $x("//div[contains(@class,'mat-form-field-infix')]//input[@input-decimal='2']");
    public static SelenideElement topUpMobileServiceHeroName = $x("//div[contains(@class,'services_hero-name')]//h1");
    public static SelenideElement topUpMobileFieldError = $x("//span[contains(@class,'field-error')]");
    public static SelenideElement topUpMobilePageSubmitButton = $x("//div[contains(@class,'form-row')]/button");
    public static SelenideElement topUpMobilePageMatHint = $x("//div[contains(@class,'mat-form-field-subscript-wrapper')]//mat-hint");
    public static SelenideElement topUpMobileServiceIcon = $x("//div[contains(@class,'service_icon')]//img");
    public static SelenideElement topUpMobileServiceTitle = $x("//h1[contains(@class,'title')]");
    public static SelenideElement topUpAdviceDefaultTitle = $x("//div[contains(@class,'advice')]//p");
    public static SelenideElement topUpAdviceDefaultText = $x("//div[contains(@class,'advice')]//div[contains(@class,'advice-default_text')]");
    public static SelenideElement topUpAdviceAddCardText = $x("//div[contains(@class,'advice')]//li[@class='card-plus']");
    public static SelenideElement topUpAdviceAdviceTemplateText = $x("//div[contains(@class,'advice')]//li[@class='advice-template']");

}
