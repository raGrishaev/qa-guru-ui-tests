package tests.homework.registration;

import config.TestBase;
import helpers.RegistrationDataModel;
import helpers.Utils;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class TestFormWithAllFields extends TestBase {
    Utils utils = new Utils();

    @Test
    void testFormWithAllFields(){
        RegistrationDataModel testData = utils.generateDataForRegistration();

        new RegistrationPage()
                .openPage()
                .setFirstName(testData.firstName())
                .setLastName(testData.lastName())
                .setUserEmail(testData.userEmail())
                .setGender(testData.gender())
                .setUserNumber(testData.userNumber())
                .setDayOfBirth(testData.year(), testData.month(), testData.day())
                .setSubject(testData.subject())
                .setHobies(testData.hobie())
                .uploadImage(testData.imagePath())
                .setCurrentAddress(testData.currentAddress())
                .setState(testData.state())
                .setCity(testData.city())
                .submit();

        new RegistrationPage()
                .checkResult("Student Name", testData.firstName() + " " + testData.lastName())
                .checkResult("Student Email", testData.userEmail())
                .checkResult("Gender", testData.gender())
                .checkResult("Mobile", testData.userNumber())
                .checkResult("Date of Birth", testData.day() + " " + testData.month() + "," + testData.year())
                .checkResult("Subjects", testData.subject())
                .checkResult("Hobbies", testData.hobie())
                .checkResult("Picture", testData.imageName())
                .checkResult("Address", testData.currentAddress())
                .checkResult("State and City", testData.state() + " " + testData.city());
    }
}
