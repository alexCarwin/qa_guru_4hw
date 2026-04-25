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
                .checkField("Student Name", firstName + " " + lastName)
                .checkField("Student Email",userEmail)
                .checkField("Gender",gender)
                .checkField("Mobile",userNumber)
                .checkField("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkField("Subjects",subjectsInput)
                .checkField("Hobbies",hobbySports)
                .checkField("Picture",imageName)
                .checkField("Address",currentAddress)
                .checkField("State and City", state + " " + city);
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
                .checkField("Student Name", firstName + " " + lastName)
                .checkField("Gender",gender)
                .checkField("Mobile",userNumber);
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
