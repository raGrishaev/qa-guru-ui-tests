package tests.homework;

import com.github.javafaker.Faker;
import config.TestBase;
import helpers.Utils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.enums.Gender;

public class TestFormWithOutLastName extends TestBase {

    Faker faker = new Faker();
    Utils utils = new Utils();

    @Test
    void testFormWithAllFields(){
        String firstName = faker.name().firstName();
        String gender = utils.getRandomEnumValue(Gender.class).toString();
        String userNumber = RandomStringUtils.random(10, false, true);
        String year = "1994";
        String month = "November";
        String day = String.valueOf(RandomUtils.nextInt(0, 27));

        new RegistrationPage()
                .openPage()
                .setFirstName(firstName)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDayOfBirth(day, month, year)
                .submit();

        new RegistrationPage()
                .checkInputBorderColor("Last Name")
                .checkTableIsHidden();
    }
}
