package web.pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProfilePage {
    public static SelenideElement settings = $x("//ul[@class='tabs-list']//a[@href='/ua/profile/settings']");


    public static void clickSettings(){
        settings.shouldBe(Condition.visible).click();
    }
}
