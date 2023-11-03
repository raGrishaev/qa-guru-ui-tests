package tests.homework;

import com.github.javafaker.Faker;
import config.TestBase;
import helpers.Utils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Test;
import page.AutomationPracticeFormPage;
import page.enums.CityByUttarPradesh;
import page.enums.Gender;
import page.enums.Hobbies;
import page.enums.Subjects;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;

public class TestFormWithAllFields extends TestBase {

    AutomationPracticeFormPage page = new AutomationPracticeFormPage();
    Faker faker = new Faker();
    Utils utils = new Utils();

    @Test
    void testFormWithAllFields(){
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userEmail = faker.internet().emailAddress();
        String gender = utils.getRandomEnumValue(Gender.class).toString();
        String userNumber = RandomStringUtils.random(10, false, true);
        String year = "1994";
        String month = "November";
        String day = String.valueOf(RandomUtils.nextInt(0, 27));
        String firstSubject = utils.getRandomEnumValue(Subjects.class).toString();
        String hobie = utils.getRandomEnumValue(Hobbies.class).toString();
        String currentAddress = faker.chuckNorris().fact();
        String state = "Uttar Pradesh";
        String city = utils.getRandomEnumValue(CityByUttarPradesh.class).toString();

        open("/automation-practice-form");

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        page.getInputFirstName().setValue(firstName);
        page.getInputLastName().setValue(lastName);
        page.getInputUserEmail().setValue(userEmail);
        page.getRadiobuttonGender().findBy(text(gender)).click();
        page.getInputUserNumber().setValue(userNumber);
        page.getInputDateOfBirthInput().click();
        page.getSelectorYear().selectOption(year);
        page.getSelectorMonth().selectOption(month);
        page.getFieldDay().findBy(text(day)).click();
        page.getInputSubjects().setValue(firstSubject).pressEnter();
        page.getMultiBoxHobbies().findBy(text(hobie)).click();
        page.getButtonUploadImage().uploadFromClasspath("2023-09-25_11h30_08.png");
        page.getTextAreaCurrentAddress().setValue(currentAddress);
        page.getFieldState().click();
        page.getSelectorState().setValue(state).pressEnter();
        page.getFieldCity().click();
        page.getSelectorCity().setValue(city).pressEnter();

        page.getButtonSubmit().click();

        page.getTableResponsive().$(byText("Student Name")).parent()
                .shouldHave(text(firstName + " " + lastName));
        page.getTableResponsive().$(byText("Student Email")).parent()
                .shouldHave(text(userEmail));
        page.getTableResponsive().$(byText("Gender")).parent()
                .shouldHave(text(gender));
        page.getTableResponsive().$(byText("Mobile")).parent()
                .shouldHave(text(userNumber));
        page.getTableResponsive().$(byText("Date of Birth")).parent()
                .shouldHave(text(day + " " + month + "," + year));
        page.getTableResponsive().$(byText("Subjects")).parent()
                .shouldHave(text(firstSubject));
        page.getTableResponsive().$(byText("Hobbies")).parent()
                .shouldHave(text(hobie));
        page.getTableResponsive().$(byText("Picture")).parent()
                .shouldHave(text("2023-09-25_11h30_08.png"));
        page.getTableResponsive().$(byText("Address")).parent()
                .shouldHave(text(currentAddress));
        page.getTableResponsive().$(byText("State and City")).parent()
                .shouldHave(text(state + " " + city));
    }
}
