package web.pageObjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class AuthRestorePage {
    public static SelenideElement restoreHeader = $x("//h1[contains(@class,'restore-header')]");




}
