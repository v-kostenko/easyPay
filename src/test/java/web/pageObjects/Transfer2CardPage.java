package web.pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class Transfer2CardPage {
    private SelenideElement cardInputField = $x("//input[contains(@class,'card__number')]");
    private SelenideElement bankLogo = $x("//figure[contains(@class,'bank-emitent')]/img");


    public void inputCardNumber(String cardNumber){
        cardInputField.shouldBe(Condition.interactable, Duration.ofSeconds(10)).setValue(cardNumber);
    }

    public boolean isBankLogoPresent(){
        return bankLogo.shouldBe(Condition.visible, Duration.ofSeconds(10)).isDisplayed();
    }




}
