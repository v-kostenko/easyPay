package web.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static web.constants.Constants.NON_EXISTENT_IBAN;
import static web.constants.Constants.NOT_FOUND_SERVICE_TEXT;
import static web.pageObjects.CatalogPopularPage.getServiceNotFoundText;
import static web.pageObjects.CatalogPopularPage.getSearchResultListSize;
import static web.steps.LoginSteps.searchByKeyWord;

@Tag("web")
@Tag("regression")
public class SearchResults extends BaseTestWeb {

    @BeforeEach
    public void setUpPath() {
        open("/");
    }

    @Test
    @DisplayName("Search by non-existent IBAN")
    @Description("Search non-existent service and check text.")
    @Owner("Volodymyr Kostenko")
    public void searchByIbanNotFound() throws InterruptedException {
        step("Search by non-existent IBAN", () -> {
            searchByKeyWord(NON_EXISTENT_IBAN);
        });
        Thread.sleep(3000); // Только после слипа тест отрабатывает
        step("Check that we don't find any service. Check text.", () -> {
            Assertions.assertEquals(getServiceNotFoundText(), NOT_FOUND_SERVICE_TEXT);
        });
    }

    @Test
    @DisplayName("Search by existent IBAN")
    @Owner("Volodymyr Kostenko")
    public void searchByExistentIBAN() throws InterruptedException {
        step("Search by existent IBAN", () -> {
            searchByKeyWord("UA223226690000026007300905964");
        });
        Thread.sleep(3000); // Только после слипа тест отрабатывает
        step("Check that ", () -> {
            Assertions.assertTrue(getSearchResultListSize() > 0);
        });
    }


}
