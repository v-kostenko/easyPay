package web.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static web.constants.Constants.*;
import static web.pageObjects.CatalogPopularPage.getServiceNotFoundText;
import static web.steps.MainPageSteps.searchByKeyWord;

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
        searchByKeyWord(NON_EXISTENT_IBAN);
        step("Check that we don't find any service. Check text.", () -> {
            Assertions.assertEquals(NOT_FOUND_SERVICE_TEXT, getServiceNotFoundText());
        });
    }

    @Test
    @DisplayName("Search by existent IBAN")
    @Owner("Volodymyr Kostenko")
    @Disabled
    public void searchByExistentIBAN() throws InterruptedException {
        searchByKeyWord(EXISTENT_IBAN);
        step("Check that ", () -> {
            //    Assertions.assertTrue(getSearchResultListSize() > 0);
        });
    }


}
