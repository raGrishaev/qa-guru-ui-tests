package tests.homework;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import helpers.Utils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import page.AutomationPracticeFormPageOblect;
import page.enums.CityByUttarPradesh;
import page.enums.Gender;
import page.enums.Hobbies;
import page.enums.Subjects;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class TestFormWithAllFields {

    AutomationPracticeFormPageOblect page = new AutomationPracticeFormPageOblect();
    Faker faker = new Faker();
    Utils utils = new Utils();
    @BeforeAll
    static void befocreAll(){
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

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
        File image = new File("src/test/resources/2023-09-25_11h30_08.png");
        String currentAddress = faker.chuckNorris().fact();
        String state = "Uttar Pradesh";//TODO: Подумать как можно выбирать рандомом штат, и с этого вариативно переходить в рандомный выбор города
        String city = utils.getRandomEnumValue(CityByUttarPradesh.class).toString();

        open("/automation-practice-form");

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
        //page.getInputSubjects().setValue(secondSubject).pressEnter();
        page.getMultiBoxHobbies().findBy(text(hobie)).click();
        page.getButtonUploadImage().uploadFile(image);
        page.getTextAreaCurrentAddress().setValue(currentAddress);
        page.getFieldState().click();
        page.getSelectorState().setValue(state).pressEnter();
        page.getFieldCity().click();
        page.getSelectorCity().setValue(city).pressEnter();

        page.getButtonSubmit().click();

        page.getTableResponsive().shouldHave(text(firstName + " " + lastName));
        page.getTableResponsive().shouldHave(text(userEmail));
        page.getTableResponsive().shouldHave(text(gender));
        page.getTableResponsive().shouldHave(text(userNumber));
        page.getTableResponsive().shouldHave(text(day + " " + month + "," + year));
        page.getTableResponsive().shouldHave(text(firstSubject));
        page.getTableResponsive().shouldHave(text(image.getName()));
        page.getTableResponsive().shouldHave(text(currentAddress));
        page.getTableResponsive().shouldHave(text(state + " " + city));
    }
}
