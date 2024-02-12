package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {
    private final SelenideElement fullName = $("#userName");
    private final SelenideElement email = $("#userEmail");
    private final SelenideElement currentAddress = $("#currentAddress");
    private final SelenideElement permanentAddress = $("#permanentAddress");
    private final SelenideElement submit = $("#submit");
    private final SelenideElement outputArea = $("#output");

    public TextBoxPage openPage() {
        open("/text-box");
        executeJavaScript("$('.fc-primary-button').click()");
        return this;
    }

    public TextBoxPage setFullName(String value) {
        fullName.setValue(value);
        return this;
    }

    public TextBoxPage setEmail(String value) {
        email.setValue(value);
        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        permanentAddress.setValue(value);
        return this;
    }

    public TextBoxPage submit() {
        submit.click();
        return this;
    }

    public TextBoxPage checkResult(String valueName, String value) {
        outputArea.$(withText(valueName)).shouldHave(text(value));
        return this;
    }
}