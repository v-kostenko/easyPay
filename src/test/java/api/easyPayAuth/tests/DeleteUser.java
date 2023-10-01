package api.easyPayAuth.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;


public class DeleteUser extends BaseTestApi {

    @Test
    @DisplayName("Get delete reasons")
    @Description("Get delete reasons")
    @Owner("Volodymyr Kostenko")
    public void getDeleteReason() {
        given().spec(requestSpecification).header("Authorization", "Bearer " + TOKEN)
                .when().get(BASE_URL_TEST + "/api/users/delete/reasons")
                .then().log().all()
                .statusCode(200)
                .body("$..reasons.length", hasSize(5));
    }




}
