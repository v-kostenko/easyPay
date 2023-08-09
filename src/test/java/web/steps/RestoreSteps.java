package web.steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.title;
import static web.pageObjects.AuthRestorePage.restoreHeader;

public class RestoreSteps {

    @Step("Get page header")
    public static String getRestorePageHeader(){
        return restoreHeader.shouldBe(Condition.visible).getText();
    }





}
