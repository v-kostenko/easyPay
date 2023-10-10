package api.auth;

import api.auth.payloads.Providers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ExternalAuth extends BaseTestApi {


    @Test
    @DisplayName("Get external providers")
    public void getExternalProviders() {
        List<Providers> providersList = given().spec(specification)
                .when().get(BASE_URL + "/api/auth/external/providers")
                .then().log().all()
                .statusCode(200)
                .extract().body().jsonPath().getList("data.providers");
        Assertions.assertEquals(providersList.size(), 2);

        // java.lang.ClassCastException
//        for (Providers provider : providersList) {
//            System.out.println(provider);
//        }
        // TODO
        // Проверить каждый объект?
    }


}
