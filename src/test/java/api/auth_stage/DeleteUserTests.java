package api.auth_stage;

import api.auth_stage.payloads.DeleteReasons;
import api.auth_stage.payloads.DeleteUser;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@Tag("api")
public class DeleteUserTests extends BaseTestApiStage {
    private static final String PATH_DELETE_CHECK = "/api/users/delete/check";
    private static final String PATH_DELETE_REASONS = "/api/users/delete/reasons";
    private static final String PATH_DELETE = "/api/users/delete";

    @Test
    @DisplayName("Check that we can delete user without EasyCard and E-money")
    @Description("Метод для перевірки можливості видалення облікового запису")
    @Owner("Volodymyr Kostenko")
    public void deleteUserCheckWithoutEasyCardAndNoEmoney() {
        // Обліковий запис не можна видалити якщо під нього відкрито карту EasyCard
        // або на рахунках електронних грошей є баланс.
        given().spec(specification).header("Authorization", "Bearer " + accessToken)
                .when().get(BASE_URL + PATH_DELETE_CHECK)
                .then().log().all()
                .statusCode(200)
                .body("data", equalTo(null));
    }

    @Test
    @DisplayName("Get delete reasons")
    @Owner("Volodymyr Kostenko")
    public void getDeleteReasons() {
        // TODO Как тут проверить все объекты?
        List<DeleteReasons> deleteReasonsList = given().spec(specification)
                .when().get(BASE_URL + PATH_DELETE_REASONS)
                .then().log().all()
                .statusCode(200)
                .extract().jsonPath().getList("data.reasons");
        Assertions.assertEquals(5, deleteReasonsList.size());
    }

    @Test
    @DisplayName("Check error handling 'INVALID_FORM_INPUT'")
    @Description("No comment is required for the reason for deletion")
    @Owner("Volodymyr Kostenko")
    public void deleteUser(){
        given().spec(specification).header("Authorization", "Bearer " + accessToken)
                .body(new DeleteUser(3))
                .when().delete(BASE_URL + PATH_DELETE)
                .then().log().all()
                .statusCode(400)
                .body("error.errorCode", equalTo("INVALID_FORM_INPUT"));
    }



}
