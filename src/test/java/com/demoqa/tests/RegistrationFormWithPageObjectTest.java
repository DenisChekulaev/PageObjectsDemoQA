package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.Page.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormWithPageObjectTest {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void configure() {
        Configuration.browser = "chrome";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1000";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {

        registrationFormPage.openPage()
                .setFirstName("Denis")
                .setLastName("Chekulaev")
                .setEmail("Chekulaev@mail.ru")
                .setGender("Male")
                .setNumber("1234567890")
                .setBirthDate("05", "August", "1986")
                .setSubjects("Economics")
                .setHobby("Sports")
                .uploadPicture("img/1.png")
                .setAddress("Rostov-on-Don")
                .setState("Uttar Pradesh")
                .setCity("Agra")
                .pressSubmit();

        registrationFormPage.checkResultsTableVisible()
                .checkResults("Student Name", "Denis Chekulaev")
                .checkResults("Student Email", "Chekulaev@mail.ru")
                .checkResults("Gender","Male")
                .checkResults("Mobile", "1234567890")
                .checkResults("Date of Birth", "05 August,1986")
                .checkResults("Subjects", "Economics")
                .checkResults("Hobbies", "Sports")
                .checkResults("Picture", "1.png")
                .checkResults("Address", "Rostov-on-Don")
                .checkResults("State and City", "Uttar Pradesh Agra");
    }

}
