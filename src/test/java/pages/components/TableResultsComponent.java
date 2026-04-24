package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TableResultsComponent {

    public void checkField(String label, String value){
        $(".table-responsive").find(byText(label)).parent().shouldHave(text(value));
    }

    public void checkFieldNotVisible(){
        $(".table-responsive").shouldNotHave(visible);
    }

}
