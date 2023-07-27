package web.pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MoneyTransferPage {
    private SelenideElement transfer2CardLink = $(By.linkText("Переказ на картку")); // Может тут можно като-то сделать лист и из листа выбирать необходимое значение?


    public static Transfer2CardPage clickTransfer2CardLink(){
     //   transfer2CardLink.click();
        return new Transfer2CardPage();
    }
}
