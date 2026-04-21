package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static tests.testdata.TestData.*;

public class TestPracticeForm extends TestBase {

    //Позитивный сценарий 1
    @Test
    void successfulFillFormTest() {
        open("/automation-practice-form");
        $("#firstName").val(firstName);
        $("#lastName").val(lastName);
        $("#userEmail").val(userEmail);
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").val(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("1996");
        $(".react-datepicker__day--018").click();
        $("#subjectsInput").setValue("Commerce").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("image.jpg");
        $("#currentAddress").val(currentAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();

        $("#submit").click();

        $(".table-responsive").shouldHave(text(firstName + " " + lastName));
        $(".table-responsive").shouldHave(text(userEmail));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text(userNumber));
        $(".table-responsive").shouldHave(text("18 May,1996"));
        $(".table-responsive").shouldHave(text("Commerce"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("Music"));
        $(".table-responsive").shouldHave(text(currentAddress));
        $(".table-responsive").shouldHave(text(state));
        $(".table-responsive").shouldHave(text(city));
    }


    //Позитивный сценарий 2
    @Test
    void PositiveOnlyRequiredFieldsTest() {
        open("/automation-practice-form");
        $("#firstName").val(firstName);
        $("#lastName").val(lastName);
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").val(userNumber);

        $("#submit").click();

        $(".table-responsive").shouldHave(text(firstName + " " + lastName));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text(userNumber));
    }


    //Негативный сценарий: вводим только имя и фамилию
    @Test
    void NegativeOnlyNameFieldTest() {
        open("/automation-practice-form");
        $("#firstName").val(firstName);
        $("#lastName").val(lastName);

        $("#submit").click();

        $(".table-responsive").shouldNotHave(visible);
    }


    //Негативный сценарий: вводим только гендер
    @Test
    void NegativeOnlyGenderFieldTest() {
        open("/automation-practice-form");
        $("#genterWrapper").$(byText("Male")).click();

        $("#submit").click();

        $(".table-responsive").shouldNotHave(visible);
    }


    //Негативный сценарий: вводим некоректный номер
    @Test
    void NegativeOnlyUserNumberFieldTest() {
        open("/automation-practice-form");
        $("#firstName").val(firstName);
        $("#lastName").val(lastName);
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").val("gregeg3");

        $("#submit").click();

        $(".table-responsive").shouldNotHave(visible);
    }


    //Позитивный сценарий на простую форму с минимумом полей
    @Test
    void successfulFillSimpleFormTest() {
        open("/text-box");
        $("#userName").val(userName);

        $("#submit").click();

        $("#output #name").shouldHave(text(userName));
    }


    //Негативный сценарий на простую форму с некорректным имейлом
    @Test
    void negativeIncorrectEmailSimpleFormTest() {
        open("/text-box");
        $("#userName").val(userName);
        $("#userEmail").val("dfg242");

        $("#submit").click();

        $("#output #email").shouldNotHave(visible);
    }
}
