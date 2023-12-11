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

public class TestFormWithOutLastName extends TestBase {

    Faker faker = new Faker();

    Utils utils = new Utils();

    @Test
    void testFormWithAllFields(){
        String firstName = faker.name().firstName();
        String gender = utils.getRandomEnumValue(Gender.class).getValue();
        String userNumber = RandomStringUtils.random(10, false, true);

        Date date = new Date();
        date.setTime(Instant.now().minus(Duration.ofDays(RandomUtils.nextInt(0, 36500))).toEpochMilli());
        DateForCalendar dateForCalendar = utils.getDateForCalendar(date);

        new RegistrationPage()
                .openPage()
                .setFirstName(firstName)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDayOfBirth(dateForCalendar.getYear(), dateForCalendar.getMonth(), dateForCalendar.getDay())
                .submit();

        new RegistrationPage()
                .checkInputBorderColor("Last Name")
                .checkTableIsHidden();
    }
}
