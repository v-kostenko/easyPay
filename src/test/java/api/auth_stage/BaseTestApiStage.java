package api.auth_stage;

import api.auth_stage.payloads.AuthDesktop;
import api.auth_stage.payloads.CreateApp;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;

import static api.auth_stage.constants.Constants.PASSWORD;
import static api.auth_stage.constants.Constants.PHONE;
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
    protected String BASE_URL = "https://authstage.easypay.ua";


    @BeforeEach
    public void setUp() {
        createApp();
        setRequestSpecification();
        generateAccessToken();
    }

    private void createApp() {
        createApp = given()
                .when().post("https://apistage.easypay.ua/api/system/createApp")
                .then().statusCode(200)
                .extract().as(CreateApp.class);

        appId = createApp.getAppId();
        pageId = createApp.getPageId();
        requestedSessionId = createApp.getRequestedSessionId();
    }

    private void setRequestSpecification(){
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

        specificationNoAppId =  new RequestSpecBuilder()
                .addHeader("Accept", "application/json")
                .addHeader("PartnerKey", "easypay-v2-test")
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
                .when().post("https://authstage.easypay.ua/api/auth/desktop")
                .then().extract().jsonPath().getString("data.access_token");
    }


}
