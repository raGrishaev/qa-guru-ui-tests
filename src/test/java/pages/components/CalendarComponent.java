package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    private final SelenideElement selectYear =  $(".react-datepicker__year-select");
    private final SelenideElement selectMonth =  $(".react-datepicker__month-select");
    public void setDate(String day, String month, String year) {
        selectYear.selectOption(year);
        selectMonth.selectOption(month);
        $(".react-datepicker__month").find(byText(day)).click();
    }
}
