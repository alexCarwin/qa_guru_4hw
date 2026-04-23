package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormPage {
    CalendarComponent calendar = new CalendarComponent();

    private SelenideElement userFirstNameInput = $("#firstName");
    private SelenideElement userLastNameInput = $("#lastName");
    private SelenideElement userEmailInput = $("#userEmail");
    private SelenideElement userNumberInput = $("#userNumber");
    private SelenideElement submitButton = $("#submit");
    private SelenideElement genterWrapperInput = $("#genterWrapper");
    private SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    private SelenideElement subjectsInput = $("#subjectsInput");
    private SelenideElement hobbyInput = $("#hobbiesWrapper");
    private SelenideElement uploadPicture = $("#uploadPicture");
    private SelenideElement addressInput = $("#currentAddress");
    private SelenideElement stateCityContainer = $("#stateCity-wrapper");
    private SelenideElement stateSelector = $("#state");
    private SelenideElement citySelector = $("#city");
    private SelenideElement tableResults = $(".table-responsive");

    public PracticeFormPage openPage(String value) {
        open(value);
        return this;
    }

    public PracticeFormPage typeFirstUserName(String value) {
        userFirstNameInput.val(value);
        return this;
    }

    public PracticeFormPage typeLastUserName(String value) {
        userLastNameInput.val(value);
        return this;
    }

    public PracticeFormPage typeUserEmail(String value) {
        userEmailInput.val(value);
        return this;
    }

    public PracticeFormPage typeUserNumber(String value) {
        userNumberInput.val(value);
        return this;
    }

    public PracticeFormPage setGender(String value) {
        genterWrapperInput.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        calendar.setDate(day, month, year);
        return this;
    }

    public PracticeFormPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public PracticeFormPage typeHobby(String value) {
        hobbyInput.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage uploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;
    }

    public PracticeFormPage typeAddress(String value) {
        addressInput.val(value);
        return this;
    }

    public PracticeFormPage setState(String value) {
        stateSelector.click();
        stateCityContainer.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage setCity(String value) {
        citySelector.click();
        stateCityContainer.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage setStateAndCity(String state, String city) {
        setState(state);
        setCity(city);
        return this;
    }

    public PracticeFormPage submitForm() {
        submitButton.click();
        return this;
    }

    public PracticeFormPage checkField(String value) {
        tableResults.shouldHave(text(value));
        return this;
    }

    public PracticeFormPage checkFieldNotVisible() {
        tableResults.shouldNotHave(visible);
        return this;
    }
}
