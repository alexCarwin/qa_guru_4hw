package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.SimpleFormPage;

import static tests.testdata.TestData.*;
import static utils.RandomUtils.*;

public class TestSimpleForm extends TestBase {
    SimpleFormPage simpleFormPage = new SimpleFormPage();

    //Позитивный сценарий на простую форму с минимумом полей
    @Test
    void successfulFillSimpleFormTest() {
        simpleFormPage
                .openPage(simpleFormUrl)
                .typeUserName(testData.userName)
                .typeEmail(testData.userEmail)
                .submitForm()
                .checkFieldPositive("name", testData.userName)
                .checkFieldPositive("email", testData.userEmail);
    }

    //Негативный сценарий на простую форму с некорректным имейлом
    @Test
    void negativeIncorrectEmailSimpleFormTest() {
        simpleFormPage
                .openPage(simpleFormUrl)
                .typeUserName(testData.userName)
                .typeEmail(testData.incorrectUserEmail)
                .submitForm()
                .checkFieldNotVisible("email");
    }

    //Негативный сценарий на простую форму с некорректным имейлом
    @Test
    void successfulFillSimpleFormTest_with_faker() {
        Faker faker = new Faker();
        String userName = faker.name().fullName();
        String userEmail = faker.internet().emailAddress();

        simpleFormPage
                .openPage(simpleFormUrl)
                .typeUserName(userName)
                .typeEmail(userEmail)
                .submitForm()
                .checkFieldPositive("name", userName)
                .checkFieldPositive("email", userEmail);
    }

    //Негативный сценарий на простую форму с некорректным имейлом
    @Test
    void successfulFillSimpleFormTest_with_utils() {
        String userName = getRandomString(10);
        String userEmail = getRandomEmail();

        simpleFormPage
                .openPage(simpleFormUrl)
                .typeUserName(userName)
                .typeEmail(userEmail)
                .submitForm()
                .checkFieldPositive("name", userName)
                .checkFieldPositive("email", userEmail);
    }
}
