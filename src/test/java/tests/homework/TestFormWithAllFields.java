package tests.homework;

import com.github.javafaker.Faker;
import config.TestBase;
import helpers.Utils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.enums.CityByUttarPradesh;
import pages.enums.Gender;
import pages.enums.Hobbies;
import pages.enums.Subjects;

public class TestFormWithAllFields extends TestBase {

    Faker faker = new Faker();
    Utils utils = new Utils();

    @Test
    void testFormWithAllFields(){
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userEmail = faker.internet().emailAddress();
        String gender = utils.getRandomEnumValue(Gender.class).getValue();
        String userNumber = RandomStringUtils.random(10, false, true);
        String year = "1994";
        String month = "November";
        String day = String.valueOf(RandomUtils.nextInt(0, 27));
        String firstSubject = utils.getRandomEnumValue(Subjects.class).toString();
        String hobie = utils.getRandomEnumValue(Hobbies.class).toString();
        String currentAddress = faker.chuckNorris().fact();
        String state = "Uttar Pradesh";
        String city = utils.getRandomEnumValue(CityByUttarPradesh.class).toString();

        new RegistrationPage()
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDayOfBirth(day, month, year)
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
                .checkResult("Date of Birth", day + " " + month + "," + year)
                .checkResult("Subjects", firstSubject)
                .checkResult("Hobbies", hobie)
                .checkResult("Picture", "2023-09-25_11h30_08.png")
                .checkResult("Address", currentAddress)
                .checkResult("State and City", state + " " + city);
    }
}
