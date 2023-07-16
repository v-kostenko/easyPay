package auth_api;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pojo.auth.AuthUser;
import pojo.delete.DeleteReason;
import pojo.delete.DeleteUserRequestBody;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;
import static io.restassured.filter.log.LogDetail.ALL;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class DeleteUser extends BaseTest{

//    @Test
//    public void getDeleteReasonUnauthorizedUser() {
//        given().spec(requestSpecification)
//                .when().get("https://authstage.easypay.ua/api/users/delete/reasons")
//                .then().log().all()
//                .statusCode(200);
//    }

    public List<DeleteReason> getDeleteReasons(){
        return given().spec(requestSpecification).header("Authorization", "Bearer " + TOKEN)
                .when().get(BASE_URL_STAGE + "/api/users/delete/reasons")
                .then().extract().jsonPath().getList("data.reasons");
    }

    @Test
    public void getDeleteReason() {
//        List<DeleteReason> deleteReasonList = new ArrayList<>();
//        deleteReasonList = given().spec(requestSpecification).header("Authorization", "Bearer " + TOKEN)
//                .when().get(BASE_URL_STAGE + "/api/users/delete/reasons")
//                .then().extract().jsonPath().getList("data.reasons");

        given().spec(requestSpecification).header("Authorization", "Bearer " + TOKEN)
                .when().get(BASE_URL_STAGE + "/api/users/delete/reasons")
                .then().log().all()
                .statusCode(200);
              //  .body("$..reasons.length", hasSize(5));
    }

    @Test
    public void deleteUserWithoutEasyCardAndEmoney() {
        DeleteUserRequestBody deleteUser = new DeleteUserRequestBody(6, "Test", "000000");
        given().spec(requestSpecification).header("Authorization", "Bearer " + TOKEN).body(deleteUser)
                .when().delete("https://authstage.easypay.ua/api/users/delete")
                .then().log().all().statusCode(200).body("data.codeType", equalTo("USER_DELETION_CONFIRMATION"));
        // need call method one more time with OTP-code to delete user
    }

    @Test
    public void deleteUserWithoutEasyCardAndEmoneyAnauthorized() {
        DeleteUserRequestBody deleteUser = new DeleteUserRequestBody(6, "Test", "000000");
        given().spec(requestSpecification).body(deleteUser)
                .when().delete("https://authstage.easypay.ua/api/users/delete")
                .then().log().all().statusCode(401);
    }

}
