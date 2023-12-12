package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.TableComponent;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private final SelenideElement inputFirstName = $("#firstName");
    private final SelenideElement inputLastName = $("#lastName");
    private final SelenideElement inputUserEmail = $("#userEmail");
    private final SelenideElement genderWrapper = $("#genterWrapper");
    private final SelenideElement inputUserNumber = $("#userNumber");
    private final SelenideElement inputDateOfBirthInput = $("#dateOfBirthInput");
    private final SelenideElement inputSubjects = $("#subjectsInput");
    private final ElementsCollection multiBoxHobbies = $$("label[for*=hobbies-checkbox]");
    private final SelenideElement buttonUploadImage = $("#uploadPicture");
    private final SelenideElement textAreaCurrentAddress = $("#currentAddress");
    private final SelenideElement fieldState = $("#state");
    private final SelenideElement selectorState = $("#react-select-3-input");
    private final SelenideElement fieldCity = $("#city");
    private final SelenideElement selectorCity = $("#react-select-4-input");
    private final SelenideElement buttonSubmit = $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();
    TableComponent tableComponent = new TableComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value){
        inputFirstName.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value){
        inputLastName.setValue(value);
        return this;
    }

    public RegistrationPage setUserEmail(String value){
        inputUserEmail.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String value){
        inputUserNumber.setValue(value);
        return this;
    }

    public RegistrationPage setDayOfBirth (String year, String month, String day){
        inputDateOfBirthInput.click();
        calendarComponent.setDate(year, month, day);
        return this;
    }

    public RegistrationPage setSubject(String value){
        inputSubjects.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobies(String value) {
        multiBoxHobbies.findBy(text(value)).click();
        return this;
    }

    public  RegistrationPage uploadImage(String path){
        buttonUploadImage.uploadFromClasspath(path);
        return this;
    }

    public RegistrationPage setCurrentAddress(String value){
        textAreaCurrentAddress.setValue(value);
        return this;
    }

    public  RegistrationPage setState(String value){
        fieldState.click();
        selectorState.setValue(value).pressEnter();
/*        ElementsCollection fieldStates = $$("[id*=react-select-3-option]");

        Random rnd = new Random();
        int i = rnd.nextInt(fieldStates.size());
        setState(fieldStates.get(i).getValue());

        fieldStates.get(i).click();*/
        return this;
    }
    public  RegistrationPage setCity(String value){
        fieldCity.click();
        selectorCity.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage submit(){
        buttonSubmit.click();
        return null;
    }

    public RegistrationPage checkResult(String key, String value) {
        tableComponent.checkValueInTable(key, value);
        return this;
    }

    public RegistrationPage checkEmpty (String key){
        tableComponent.checkEmpty(key);
        return this;
    }

    public RegistrationPage checkInputBorderColor(String placeholder) {
        $(byAttribute("placeholder", placeholder)).shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        return this;
    }

    public RegistrationPage checkTableIsHidden(){
        tableComponent.checkTableIsHidden();
        return this;
    }
}
