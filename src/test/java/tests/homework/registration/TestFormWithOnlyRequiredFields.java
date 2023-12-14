package tests.homework.registration;

import config.TestBase;
import helpers.RegistrationDataModel;
import helpers.Utils;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class TestFormWithOnlyRequiredFields extends TestBase {
    Utils utils = new Utils();

    @Test
    void testFormWithOutLastName(){
        RegistrationDataModel testData = utils.generateDataForRegistration();

        new RegistrationPage()
                .openPage()
                .setFirstName(testData.firstName())
                .setLastName(testData.lastName())
                .setGender(testData.gender())
                .setUserNumber(testData.userNumber())
                .setDayOfBirth(testData.year(), testData.month(), testData.day())
                .submit();

        new RegistrationPage()
                .checkResult("Student Name", testData.firstName() + " " + testData.lastName())
                .checkEmpty("Student Email")
                .checkResult("Gender", testData.gender())
                .checkResult("Mobile", testData.userNumber())
                .checkResult("Date of Birth", testData.day() + " " + testData.month() + "," + testData.year())
                .checkEmpty("Subjects")
                .checkEmpty("Hobbies")
                .checkEmpty("Picture")
                .checkEmpty("Address")
                .checkEmpty("State and City");
    }
}
