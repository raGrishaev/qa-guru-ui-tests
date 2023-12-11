package tests.homework;

import com.github.javafaker.Faker;
import config.TestBase;
import helpers.DateForCalendar;
import helpers.Utils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.enums.Gender;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class TestFormWithOnlyRequiredFields extends TestBase {

    Faker faker = new Faker();
    Utils utils = new Utils();

    @Test
    void testFormWithAllFields(){
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String gender = utils.getRandomEnumValue(Gender.class).getValue();
        String userNumber = RandomStringUtils.random(10, false, true);

        Date date = new Date();
        date.setTime(Instant.now().minus(Duration.ofDays(RandomUtils.nextInt(0, 36500))).toEpochMilli());
        DateForCalendar dateForCalendar = utils.getDateForCalendar(date);

        new RegistrationPage()
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDayOfBirth(dateForCalendar.getYear(), dateForCalendar.getMonth(), dateForCalendar.getDay())
                .submit();

        new RegistrationPage()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkEmpty("Student Email")
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", dateForCalendar.getDay() + " " + dateForCalendar.getMonth() + "," + dateForCalendar.getYear())
                .checkEmpty("Subjects")
                .checkEmpty("Hobbies")
                .checkEmpty("Picture")
                .checkEmpty("Address")
                .checkEmpty("State and City");
    }
}
