package api.auth_stage;

import api.auth_stage.payloads.DeleteReasons;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;

import java.util.List;

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
        given().spec(specification).header("Authorization", "Bearer " + accessToken)
                .when().get(BASE_URL + "/api/users/delete/check")
                .then().log().all()
                .statusCode(200)
                .body("data", equalTo(null));
    }

    @Test
    @DisplayName("Get delete reasons")
    @Owner("Volodymyr Kostenko")
    public void getDeleteReasons() {
        List<DeleteReasons> deleteReasonsList = given().spec(specification)
                .when().get(BASE_URL + "/api/users/delete/reasons")
                .then().log().all()
                .statusCode(200)
                .extract().jsonPath().getList("data.reasons");
        Assertions.assertEquals(5, deleteReasonsList.size());
    }



}
