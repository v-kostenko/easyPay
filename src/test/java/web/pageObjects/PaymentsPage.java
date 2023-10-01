package web.pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class PaymentsPage {
    public static SelenideElement profileHeaderTitle = $x("//h1[contains(@class,'profile__header-title')]");
    public static SelenideElement transferLink = $x("//a[@class='menu__link']");




    public static String getProfileHeaderTitleOnPaymentsPage(){
        return profileHeaderTitle.shouldBe(Condition.visible).getText();
    }

    public MoneyTransferPage clickTransferLink(){
        transferLink.click();
        return new MoneyTransferPage();
    }

}
