package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.TableResultsComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormPage {
    CalendarComponent calendar = new CalendarComponent();
    TableResultsComponent tableResults = new TableResultsComponent();

    private final SelenideElement userFirstNameInput = $("#firstName");
    private final SelenideElement userLastNameInput = $("#lastName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement userNumberInput = $("#userNumber");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement genterWrapperInput = $("#genterWrapper");
    private final SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    private final SelenideElement subjectsInput = $("#subjectsInput");
    private final SelenideElement hobbyInput = $("#hobbiesWrapper");
    private final SelenideElement uploadPicture = $("#uploadPicture");
    private final SelenideElement addressInput = $("#currentAddress");
    private final SelenideElement stateCityContainer = $("#stateCity-wrapper");
    private final SelenideElement stateSelector = $("#state");
    private final SelenideElement citySelector = $("#city");

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

    public PracticeFormPage checkField(String label, String value) {
        tableResults.checkField(label, value);
        return this;
    }

    public PracticeFormPage checkFieldNotVisible() {
        tableResults.checkFieldNotVisible();
        return this;
    }
}
