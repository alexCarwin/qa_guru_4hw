package tests;

import org.junit.jupiter.api.Test;
import pages.SimpleFormPage;

import static tests.testdata.TestData.*;

public class TestSimpleForm extends TestBase {
    SimpleFormPage simpleFormPage = new SimpleFormPage();


    //Позитивный сценарий на простую форму с минимумом полей
    @Test
    void successfulFillSimpleFormTest() {
        simpleFormPage
                .openPage(simpleFormUrl)
                .typeUserName(userName)
                .submitForm()
                .checkFieldPositive("name", userName);
    }


    //Негативный сценарий на простую форму с некорректным имейлом
    @Test
    void negativeIncorrectEmailSimpleFormTest() {

        simpleFormPage
                .openPage(simpleFormUrl)
                .typeUserName(userName)
                .typeEmail(incorrectUserEmail)
                .submitForm()
                .checkFieldNotVisible("email");

    }
}
