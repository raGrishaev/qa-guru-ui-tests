package tests.homework;

import java.io.File;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import helpers.Utils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import page.AutomationPracticeFormPageOblect;
import page.enums.*;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
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
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void testFormWithAllFields(){
        String state = "Uttar Pradesh";//TODO: Подумать как можно выбирать рандомом штат, и с этого вариативно переходить в рандомный выбор города
        File image = new File("src/test/resources/2023-09-25_11h30_08.png");
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userEmail = faker.internet().emailAddress();


        open("/automation-practice-form");

        page.getInputFirstName().setValue(firstName);
        page.getInputLastName().setValue(lastName);
        page.getInputUserEmail().setValue(userEmail);
        page.getRadiobuttonGender().findBy(text(utils
                .getRandomEnumValue(Gender.class).toString()))
                .click();
        page.getInputUserNumber().setValue(RandomStringUtils.random(10, false, true));
        page.getInputDateOfBirthInput().click();
        page.getSelectorYear().selectOption(RandomUtils.nextInt(0, 199));
        page.getSelectorMonth().selectOption(RandomUtils.nextInt(0, 11));
        page.getFieldDay().findBy(text(String.valueOf(RandomUtils.nextInt(0, 27))))
                .click();
        page.getInputSubjects().setValue(utils.getRandomEnumValue(Subjects.class)
                .toString()).pressEnter();
        page.getMultiBoxHobbies().findBy(text(utils
                .getRandomEnumValue(Hobbies.class).toString()))
                .click();
        page.getButtonUploadImage().uploadFile(image);
        page.getTextAreaCurrentAddress().setValue(faker.chuckNorris().fact());
        page.getFieldState().click();
        page.getSelectorState().setValue(state).pressEnter();
        page.getFieldCity().click();
        page.getSelectorCity().setValue(utils.getRandomEnumValue(CityByUttarPradesh.class).toString()).pressEnter();

        page.getButtonSubmit().click();
    }
}
