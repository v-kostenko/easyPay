package web.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static io.qameta.allure.Allure.step;
import static web.constants.Constants.NOT_FOUND_SERVICE_TEXT;
import static web.pageObjects.CatalogPopularPage.getServiceNotFoundText;
import static web.pageObjects.CatalogPopularPage.isSearchResultListEmpty;
import static web.steps.LoginSteps.searchByKeyWord;

@Tag("web")
@Tag("regression")
public class SearchResults extends BaseTestWeb {

    @Test
    @DisplayName("Search by non-existent IBAN")
    @Description("Search non-existent service and check text.")
    @Owner("Volodymyr Kostenko")
    public void searchByIbanNotFound() throws InterruptedException {
        step("Search by non-existent IBAN", () -> {
            searchByKeyWord("UA223226690000026007300900000");
        });
        // Thread.sleep(3000); // Только после слипа тест отрабатывает
        step("Check that we don't find any service. Check text.", () -> {
            Assertions.assertEquals(getServiceNotFoundText(), NOT_FOUND_SERVICE_TEXT);
        });
    }

    @Test
    public void searchByExistentIBAN() {
        step("Search by non-existent IBAN", () -> {
            searchByKeyWord("UA223226690000026007300900000");
        });
        step("", () -> {
            Assertions.assertFalse(isSearchResultListEmpty(), "" );
        });

    }


}
