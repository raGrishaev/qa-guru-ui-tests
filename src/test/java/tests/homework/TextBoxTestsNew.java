package tests.homework;

import com.github.javafaker.Faker;
import config.TestBase;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTestsNew extends TestBase {

    @Test
    void fillFormTest() {

        Faker faker = new Faker();

        String fullName = faker.name().fullName();
        String userEmail = faker.internet().emailAddress();
        String currentAddress = faker.chuckNorris().fact();
        String permanentAddress = faker.chuckNorris().fact();

        new TextBoxPage()
                .openPage()
                .setFullName(fullName)
                .setEmail(userEmail)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .submit();

        new TextBoxPage()
                .checkResult("Name", fullName)
                .checkResult("Email", userEmail)
                .checkResult("Current Address", currentAddress)
                .checkResult("Permananet Address", permanentAddress);
    }
}
