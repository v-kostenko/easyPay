package web.pageObjects;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$$x;


import java.util.List;

public class CatalogPopularPage {

    private List<SelenideElement> searchResultList = $$x("//div[contains(@class,'payment-services__container')]//div[contains(@class,'service-item_name')]/span");

    public boolean isSearchResultListEmpty(){
        System.out.println("Found elements: " + searchResultList.size());
        return searchResultList.isEmpty();
    }



}
