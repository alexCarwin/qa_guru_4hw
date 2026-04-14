package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestPracticeForm extends TestBase {


    @Test
    void successfulFillFormTest() {
        open("/automation-practice-form");
        $("#firstName").val("Zulu");
        $("#lastName").val("Zinho");
        $("#userEmail").val("fdsf@yadn.xu");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").val("8911241555");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("1996");
        $(".react-datepicker__day--018").click();
        $("#subjectsInput").setValue("Commerce").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("image.jpg");
        $("#currentAddress").val("current address");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Rajasthan")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Jaipur")).click();

        $("#submit").click();

        $(".table-responsive").shouldHave(text("Zulu Zinho"));
        $(".table-responsive").shouldHave(text("fdsf@yadn.xu"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("8911241555"));
        $(".table-responsive").shouldHave(text("18 May,1996"));
        $(".table-responsive").shouldHave(text("Commerce"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("Music"));
        $(".table-responsive").shouldHave(text("current address"));
        $(".table-responsive").shouldHave(text("Rajasthan"));
        $(".table-responsive").shouldHave(text("Jaipur"));

    }


    @Test
    void PositiveOnlyRequiredFieldsTest(){
        open("/automation-practice-form");
        $("#firstName").val("Zulu");
        $("#lastName").val("Zinho");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").val("8911241555");

        $("#submit").click();

        $(".table-responsive").shouldHave(text("Zulu Zinho"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("8911241555"));

    }

}
