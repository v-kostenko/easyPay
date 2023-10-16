package web.pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class SearchResultsPage {

    private static ElementsCollection searchResultList = $$x("//div[contains(@class,'payment-services__container')]//a");
    public static SelenideElement serviceNotFoundText = $x("//section[@class='service-not-found']//p");
    public static SelenideElement searchTagTitle = $x("//h2[contains(@class,'search-tags_title')]");


    public static int getSearchResultListSize() throws InterruptedException {
        Thread.sleep(1500); // Находит 16 елементов, не то что нужно
        System.out.println("Found elements: " + searchResultList.size());
        return searchResultList.size();
    }

    @Step("Get service not found text")
    public static String getServiceNotFoundText() {
        return serviceNotFoundText.shouldBe(Condition.visible).getText();
    }

    @Step("Check search result title")
    public static String getSearchResultTitle(){
        return searchTagTitle.should(Condition.visible).getText().trim();
    }




}
