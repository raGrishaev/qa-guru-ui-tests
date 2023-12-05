package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TableComponent {
    private final static SelenideElement resultsTable = $(".table-responsive");

    public void checkValueInTable(String key, String value) {
        resultsTable.$(byText(key)).parent().shouldHave(text(value));
    }

    public void checkEmpty(String key) {
        resultsTable.$(byText(key)).sibling(0).shouldHave(empty);
    }

    public void checkTableIsHidden() {
        //resultsTable.shouldNotBe(appear);
        resultsTable.shouldBe(hidden);
    }
}
