package com.easypay.api.easyPayApi.tests;

import com.easypay.api.easyPayApi.pojo.Contact;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@Tag("api")
@Tag("regression")
public class ContactsTest extends BaseTestApi {

    @Test
    @DisplayName("Get contacts")
    @Description("Get contacts")
    @Owner("Volodymyr Kostenko")
    @Severity(SeverityLevel.NORMAL)
    public void getContacts() {
        given().spec(specification).log().all()
                .when().get("https://apistage.easypay.ua/api/contacts/get")
                .then().log().all().statusCode(200);
    }

    @Test
    @DisplayName("Get contact by existing id")
    @Description("Get contact by existing id")
    @Owner("Volodymyr Kostenko")
    public void getContactById() {
        // Тут наверное нужно вызвать метод getContacts() и отуда вытащить существующие id?
        String contactId = "13";

        given().spec(specification).log().all()
                .when().get("https://apistage.easypay.ua/api/contacts/get/" + contactId)
                .then().log().all().statusCode(200);
    }

    @Test
    @DisplayName("Add new contact")
    @Description("Add new contact")
    @Owner("Volodymyr Kostenko")
    public void addContact() {
        Contact contact = new Contact("380660051447", "Kostenko", "Volodymyr", true);
        given().spec(specification).log().all().body(contact)
                .when().post("https://apidev.easypay.ua/api/contacts/add")
                .then().log().all();
    }

    @Test
    @DisplayName("Delete contact by ID")
    @Description("")
    @Owner("Volodymyr Kostenko")
    public void deleteContactById() {
        // First addContact();
        // Get id
        // Delete contact by id
        String id = "1000";
        given().spec(specification)
                .when().delete("https://apidev.easypay.ua/api/contacts/delete/contact/" + id)
                .then().statusCode(200);
    }


}
