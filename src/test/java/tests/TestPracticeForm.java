package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestPracticeForm extends TestBase {


    @Test
    void successfulFillFormTest(){
        open("/automation-practice-form");
        $("#firstName").val("Zalu");
        $("#lastName").val("Pa");
        $("#userEmail").val("fdsf@yadn.xu");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").val("89111111111");
        $("#dateOfBirthInput").val("12 Apr 1990").pressEnter();
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

        $("[id=output] [id=name]").shouldHave(text("Alex White"));
        $("[id=output] [id=email]").shouldHave(text("dfgdf@bfsd.ru"));
        $("[id=output] [id=currentAddress]").shouldHave(text("first address 323"));
        $("[id=output] [id=permanentAddress ]").shouldHave(text("second address 443"));

    }


}
