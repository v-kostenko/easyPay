package web.pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;


import java.util.List;

public class CatalogPopularPage {

    private static List<SelenideElement> searchResultList = $$x("//div[contains(@class,'payment-services__container')]//a");
    public static SelenideElement serviceNotFoundText = $x("//section[@class='service-not-found']//p");
    public static SelenideElement searchTagTitle = $x("//h2[contains(@class,'search-tags_title')]");


    public static boolean isSearchResultListEmpty() throws InterruptedException {
        searchTagTitle.shouldBe(Condition.visible);
        Thread.sleep(1500); // Находит 16 елементов, не то что нужно
        System.out.println("Found elements: " + searchResultList.size());
        return searchResultList.isEmpty();
    }

    public static String getServiceNotFoundText(){
        return serviceNotFoundText.shouldBe(Condition.visible).getText();
    }



}
