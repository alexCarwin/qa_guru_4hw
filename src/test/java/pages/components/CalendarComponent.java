package pages.components;

import static com.codeborne.selenide.Selenide.$;
import static tests.testdata.TestData.*;

public class CalendarComponent {


    public void setDate(String day, String month, String year) {
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__day--0" + day).click();
    }
}
