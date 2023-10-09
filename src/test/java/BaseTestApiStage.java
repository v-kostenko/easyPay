import api.auth.payloads.AuthDesktop;
import api.auth.payloads.CreateApp;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;

import static api.auth.constants.Constants.PASSWORD;
import static api.auth.constants.Constants.PHONE;
import static io.restassured.RestAssured.given;

public class BaseTestApiStage {
    protected String appId = "";
    protected String pageId = "";
    protected String requestedSessionId = "";

    protected String accessToken = "";
    public CreateApp createApp;
    public static RequestSpecification specification;
    public static RequestSpecification specificationNoAppId;
    public static RequestSpecification specificationNoPartnerKey;
    public static RequestSpecification specificationPtksNoAppId;
    protected String BASE_URL = "https://auth.easypay.ua";

    public void test() {
        if (System.getProperty("env", "stage") != "prod") {
            BASE_URL = "https://authstage.easypay.ua";
        } else {
            BASE_URL = "";
        }
    }


    @BeforeEach
    public void setUp() {
        createApp();
        setRequestSpecification();
        generateAccessToken();
    }

    private void createApp() {
        createApp = given()
                .when().post("https://api.easypay.ua/api/system/createApp")
                .then().statusCode(200)
                .extract().as(CreateApp.class);

        appId = createApp.getAppId();
        pageId = createApp.getPageId();
        requestedSessionId = createApp.getRequestedSessionId();
    }

    private void setRequestSpecification() {
        specification = new RequestSpecBuilder()
                .addHeader("Accept", "application/json")
                .addHeader("PartnerKey", "easypay-v2-test")
                .addHeader("locale", "UA")
                .addHeader("koatuu", "8000000000")
                .addHeader("AppId", appId)
                .addHeader("PageId", pageId)
                .addHeader("Content-Type", "application/json")
                .log(LogDetail.ALL)
                .build();

        specificationNoAppId = new RequestSpecBuilder()
                .addHeader("Accept", "application/json")
                .addHeader("PartnerKey", "easypay-v2-test")
                .addHeader("locale", "UA")
                .addHeader("koatuu", "8000000000")
                .addHeader("AppId", appId + "xxx")
                .addHeader("PageId", pageId)
                .addHeader("Content-Type", "application/json")
                .log(LogDetail.ALL)
                .build();

        specificationPtksNoAppId = new RequestSpecBuilder()
                .addHeader("Accept", "application/json")
                .addHeader("PartnerKey", "easypay-ptks")
                .addHeader("locale", "UA")
                .addHeader("koatuu", "8000000000")
                .addHeader("AppId", appId + "xxx")
                .addHeader("PageId", pageId)
                .addHeader("Content-Type", "application/json")
                .log(LogDetail.ALL)
                .build();

        specificationNoPartnerKey = new RequestSpecBuilder()
                .addHeader("Accept", "application/json")
                .addHeader("locale", "UA")
                .addHeader("koatuu", "8000000000")
                .addHeader("AppId", appId + "xxx")
                .addHeader("PageId", pageId)
                .addHeader("Content-Type", "application/json")
                .log(LogDetail.ALL)
                .build();

    }

    private void generateAccessToken() {
        AuthDesktop authDesktop = new AuthDesktop(PHONE, PASSWORD);

        accessToken = given().spec(specification).body(authDesktop)
                .when().post("https://auth.easypay.ua/api/auth/desktop")
                .then().extract().jsonPath().getString("data.access_token");
    }


}
