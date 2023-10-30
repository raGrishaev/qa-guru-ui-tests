package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AutomationPracticeFormPageOblect {
    private final SelenideElement inputFirstName = $("#firstName");
    private final SelenideElement inputLastName = $("#lastName");
    private final SelenideElement inputUserEmail = $("#userEmail");
    private final ElementsCollection radiobuttonGender = $$("label[for*=gender-radio]");
    private final SelenideElement inputUserNumber = $("#userNumber");
    private final SelenideElement inputDateOfBirthInput = $("#dateOfBirthInput");
    private final SelenideElement selectorMonth = $(".react-datepicker__month-select");
    private final SelenideElement selectorYear = $(".react-datepicker__year-select");
    private final ElementsCollection fieldDay = $$(".react-datepicker__day");
    private final SelenideElement inputSubjects = $("#subjectsInput"); //там всё сложнее конечно. Надо время подумать
    private final ElementsCollection multiBoxHobbies = $$("label[for*=hobbies-checkbox]");
    private final SelenideElement buttonUploadImage = $("#uploadPicture");
    private final SelenideElement textAreaCurrentAddress = $("#currentAddress");
    private final SelenideElement fieldState = $("#state");
    private final SelenideElement selectorState = $("#react-select-3-input");
    private final SelenideElement fieldCity = $("#city");
    private final SelenideElement selectorCity = $("#react-select-4-input");
    private final SelenideElement buttonSubmit = $("#submit");
    private final SelenideElement tableResponsive = $(".table-responsive");

    public SelenideElement getInputFirstName() {
        return inputFirstName;
    }

    public SelenideElement getInputLastName() {
        return inputLastName;
    }

    public SelenideElement getInputUserEmail() {
        return inputUserEmail;
    }

    public ElementsCollection getRadiobuttonGender() {
        return radiobuttonGender;
    }

    public SelenideElement getInputUserNumber() {
        return inputUserNumber;
    }

    public SelenideElement getInputDateOfBirthInput() {
        return inputDateOfBirthInput;
    }

    public SelenideElement getSelectorMonth() {
        return selectorMonth;
    }

    public SelenideElement getSelectorYear() {
        return selectorYear;
    }

    public ElementsCollection getFieldDay() {
        return fieldDay;
    }

    public SelenideElement getInputSubjects() {
        return inputSubjects;
    }

    public ElementsCollection getMultiBoxHobbies() {
        return multiBoxHobbies;
    }

    public SelenideElement getButtonUploadImage() {
        return buttonUploadImage;
    }

    public SelenideElement getTextAreaCurrentAddress() {
        return textAreaCurrentAddress;
    }

    public SelenideElement getFieldState() {
        return fieldState;
    }

    public SelenideElement getSelectorState() {
        return selectorState;
    }

    public SelenideElement getFieldCity() {
        return fieldCity;
    }

    public SelenideElement getSelectorCity() {
        return selectorCity;
    }

    public SelenideElement getButtonSubmit() {
        return buttonSubmit;
    }

    public SelenideElement getTableResponsive() {
        return tableResponsive;
    }
}
