package tests;

import org.junit.jupiter.api.Test;
import pages.SimpleFormPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
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


        open(simpleFormUrl);
        $("#userName").val(userName);

        $("#submit").click();

        $("#output #name").shouldHave(text(userName));
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

        open(simpleFormUrl);
        $("#userName").val(userName);
        $("#userEmail").val(incorrectUserEmail);

        $("#submit").click();


        $("#output #email").shouldNotHave(visible);
    }
}
