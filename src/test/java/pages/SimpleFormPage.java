package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SimpleFormPage {

    private final SelenideElement userNameInput =  $("#userName");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement outputResult = $("#output");

    public SimpleFormPage openPage(String url){
        open(url);
        return this;
    }

    public SimpleFormPage typeUserName(String val) {
        userNameInput.val(val);
        return this;
    }

    public SimpleFormPage typeEmail(String val) {
        userEmailInput.val(val);
        return this;
    }

    public SimpleFormPage submitForm(){
        submitButton.click();
        return this;
    }

    public SimpleFormPage checkFieldPositive(String key, String value){
        outputResult.$(byId(key)).shouldHave(text(value));
        return this;
    }

    public SimpleFormPage checkFieldNotVisible(String key){
        outputResult.$(byId(key)).shouldNotHave(visible);
        return this;
    }
}
