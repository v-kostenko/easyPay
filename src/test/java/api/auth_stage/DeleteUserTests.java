package api.auth_stage;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@Tag("api")
public class DeleteUserTests extends BaseTestApiStage {
    private static final String PATH = "";

    @Test
    @DisplayName("Check that we can delete user")
    @Description("Метод для перевірки можливості видалення облікового запису")
    @Owner("Volodymyr Kostenko")
    public void deleteUserCheckWithoutEasyCardAndNoEmoney() {
        // Обліковий запис не можна видалити якщо під нього відкрито карту EasyCard
        // або на рахунках електронних грошей є баланс.
        given().spec(specification)
                .when().get("https://authstage.easypay.ua/api/users/delete/check")
                .then().statusCode(200)
                .body("data", equalTo(null));
    }

    @Test
    @Owner("Volodymyr Kostenko")
    public void getDeleteReasons() {
        given().spec(specification)
                .when().get("https://authstage.easypay.ua/api/users/delete/reasons")
                .then().statusCode(200);
    }

    @Test
    @Disabled
    public void deleteUser(){
        // GET /api/users /delete/reasons

        // delete
        given().spec(specification)
                .when().delete("https://authstage.easypay.ua/api/users/delete");
    }


}
