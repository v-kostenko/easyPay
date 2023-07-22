package web.tests;

import org.junit.jupiter.api.Test;
import web.pageObjects.CatalogPopularPage;
import web.pageObjects.MainPage;
import org.junit.jupiter.api.Assertions;


public class SearchResults extends BaseTestWeb {

    @Test
    public void checkIbanEdrpouTitle() throws InterruptedException {
        MainPage mainPage = new MainPage();
        CatalogPopularPage catalogPopularPage = mainPage.searchByKeyWord("UA223226690000026007300905960");
        Thread.sleep(3000); // Только после слипа тест отрабатывает
        Assertions.assertFalse(catalogPopularPage.isSearchResultListEmpty());
    }


}
