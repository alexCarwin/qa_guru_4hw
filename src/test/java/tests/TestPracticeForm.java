package tests;

import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

import static tests.testdata.TestData.*;

public class TestPracticeForm extends TestBase {

    PracticeFormPage practiceFormPage = new PracticeFormPage();

    //Позитивный сценарий 1
    @Test
    void successfulFillFormTest() {
        practiceFormPage
                .openPage(practiceFormUrl)
                .typeFirstUserName(firstName)
                .typeLastUserName(lastName)
                .typeUserEmail(userEmail)
                .setGender(gender)
                .typeUserNumber(userNumber)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubject(subjectsInput)
                .typeHobby(hobbySports)
                .uploadPicture(imageName)
                .typeAddress(currentAddress)
                .setStateAndCity(state, city)
                .submitForm()
                .checkField(userEmail)
                .checkField(firstName)
                .checkField(lastName)
                .checkField(userEmail)
                .checkField(gender)
                .checkField(userNumber)
                .checkField(dayOfBirth)
                .checkField(monthOfBirth)
                .checkField(yearOfBirth)
                .checkField(subjectsInput)
                .checkField(hobbySports)
                .checkField(currentAddress)
                .checkField(state)
                .checkField(city);
    }

    //Позитивный сценарий 2
    @Test
    void PositiveOnlyRequiredFieldsTest() {

        practiceFormPage
                .openPage(practiceFormUrl)
                .typeFirstUserName(firstName)
                .typeLastUserName(lastName)
                .setGender(gender)
                .typeUserNumber(userNumber)
                .submitForm()
                .checkField(firstName)
                .checkField(lastName)
                .checkField(gender)
                .checkField(userNumber);
    }

    @Test
    void PositiveOnlyRequiredFieldsTest_chaining() {
        practiceFormPage
                .openPage(practiceFormUrl)
                .typeFirstUserName(firstName)
                .typeLastUserName(lastName)
                .typeUserEmail(userEmail)
                .setGender(gender)
                .typeUserNumber(userNumber)
                .submitForm()
                .checkField(firstName)
                .checkField(lastName)
                .checkField(gender)
                .checkField(userNumber);
    }

    //Негативный сценарий: вводим только имя и фамилию
    @Test
    void NegativeOnlyNameFieldTest() {
        practiceFormPage
                .openPage(practiceFormUrl)
                .typeFirstUserName(firstName)
                .typeLastUserName(lastName)
                .submitForm()
                .checkFieldNotVisible();
    }

    //Негативный сценарий: вводим только гендер
    @Test
    void NegativeOnlyGenderFieldTest() {
        practiceFormPage
                .openPage(practiceFormUrl)
                .setGender(gender)
                .submitForm()
                .checkFieldNotVisible();
    }

    //Негативный сценарий: вводим некоректный номер
    @Test
    void NegativeOnlyUserNumberFieldTest() {
        practiceFormPage
                .openPage(practiceFormUrl)
                .typeFirstUserName(firstName)
                .typeLastUserName(lastName)
                .setGender(gender)
                .typeUserNumber(incorrectUserNumber)
                .submitForm()
                .checkFieldNotVisible();
    }
}
