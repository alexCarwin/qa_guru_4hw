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
        open(practiceFormUrl);
        $("#firstName").val(firstName);
        $("#lastName").val(lastName);
        $("#userEmail").val(userEmail);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").val(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__day--0"+dayOfBirth).click();
        $("#subjectsInput").setValue(subjectsInput).pressEnter();
        $("#hobbiesWrapper").$(byText(hobbySports)).click();
        $("#hobbiesWrapper").$(byText(hobbyMusic)).click();
        $("#uploadPicture").uploadFromClasspath(imageName);
        $("#currentAddress").val(currentAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();

        $("#submit").click();

        $(".table-responsive").shouldHave(text(firstName + " " + lastName));
        $(".table-responsive").shouldHave(text(userEmail));
        $(".table-responsive").shouldHave(text(gender));
        $(".table-responsive").shouldHave(text(userNumber));
        $(".table-responsive").shouldHave(text(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth));
        $(".table-responsive").shouldHave(text(subjectsInput));
        $(".table-responsive").shouldHave(text(hobbySports));
        $(".table-responsive").shouldHave(text(hobbyMusic));
        $(".table-responsive").shouldHave(text(currentAddress));
        $(".table-responsive").shouldHave(text(state));
        $(".table-responsive").shouldHave(text(city));
    }


    //Позитивный сценарий 2
    @Test
    void PositiveOnlyRequiredFieldsTest() {
        open(practiceFormUrl);
        $("#firstName").val(firstName);
        $("#lastName").val(lastName);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").val(userNumber);

        $("#submit").click();

        $(".table-responsive").shouldHave(text(firstName + " " + lastName));
        $(".table-responsive").shouldHave(text(gender));
        $(".table-responsive").shouldHave(text(userNumber));
    }


    //Негативный сценарий: вводим только имя и фамилию
    @Test
    void NegativeOnlyNameFieldTest() {
        open(practiceFormUrl);
        $("#firstName").val(firstName);
        $("#lastName").val(lastName);

        $("#submit").click();

        $(".table-responsive").shouldNotHave(visible);
    }


    //Негативный сценарий: вводим только гендер
    @Test
    void NegativeOnlyGenderFieldTest() {
        open(practiceFormUrl);
        $("#genterWrapper").$(byText(gender)).click();

        $("#submit").click();

        $(".table-responsive").shouldNotHave(visible);
    }


    //Негативный сценарий: вводим некоректный номер
    @Test
    void NegativeOnlyUserNumberFieldTest() {
        open(practiceFormUrl);
        $("#firstName").val(firstName);
        $("#lastName").val(lastName);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").val(incorrectUserNumber);

        $("#submit").click();

        $(".table-responsive").shouldNotHave(visible);
    }


    //Позитивный сценарий на простую форму с минимумом полей
    @Test
    void successfulFillSimpleFormTest() {
        open(simpleFormUrl);
        $("#userName").val(userName);

        $("#submit").click();

        $("#output #name").shouldHave(text(userName));
    }


    //Негативный сценарий на простую форму с некорректным имейлом
    @Test
    void negativeIncorrectEmailSimpleFormTest() {
        open(simpleFormUrl);
        $("#userName").val(userName);
        $("#userEmail").val(incorrectUserEmail);

        $("#submit").click();

        $("#output #email").shouldNotHave(visible);
    }
}
