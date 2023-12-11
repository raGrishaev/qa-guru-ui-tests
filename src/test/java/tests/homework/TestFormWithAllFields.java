package tests.homework;

import com.github.javafaker.Faker;
import config.TestBase;
import helpers.DateForCalendar;
import helpers.Utils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.enums.CityByUttarPradesh;
import pages.enums.Gender;
import pages.enums.Hobbies;
import pages.enums.Subjects;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class TestFormWithAllFields extends TestBase {

    Faker faker = new Faker(/*new Locale("ru")*/);
    Utils utils = new Utils();

    @Test
    void testFormWithAllFields(){
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userEmail = faker.internet().emailAddress();
        String gender = utils.getRandomEnumValue(Gender.class).getValue();
        String userNumber = RandomStringUtils.random(10, false, true);
        String firstSubject = utils.getRandomEnumValue(Subjects.class).toString();
        String hobie = utils.getRandomEnumValue(Hobbies.class).toString();
        String currentAddress = faker.chuckNorris().fact();
        String state = "Uttar Pradesh";
        String city = utils.getRandomEnumValue(CityByUttarPradesh.class).toString();

        Date date = new Date();
        date.setTime(Instant.now().minus(Duration.ofDays(RandomUtils.nextInt(0, 36500))).toEpochMilli());
        DateForCalendar dateForCalendar = utils.getDateForCalendar(date);

        new RegistrationPage()
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDayOfBirth(dateForCalendar.getYear(), dateForCalendar.getMonth(), dateForCalendar.getDay())
                .setSubject(firstSubject)
                .setHobies(hobie)
                .uploadImage("2023-09-25_11h30_08.png")
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .submit();

        new RegistrationPage()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", dateForCalendar.getDay() + " " + dateForCalendar.getMonth() + "," + dateForCalendar.getYear())
                .checkResult("Subjects", firstSubject)
                .checkResult("Hobbies", hobie)
                .checkResult("Picture", "2023-09-25_11h30_08.png")
                .checkResult("Address", currentAddress)
                .checkResult("State and City", state + " " + city);
    }
}
