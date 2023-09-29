package com.easypay.web.steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.easypay.web.pageObjects.AuthRestorePage.restoreHeader;

public class RestoreSteps {

    @Step("Get page header")
    public static String getRestorePageHeader(){
        return restoreHeader.shouldBe(Condition.visible).getText();
    }





}
