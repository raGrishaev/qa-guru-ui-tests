package tests.homework.registration;

import config.TestBase;
import helpers.RegistrationDataModel;
import helpers.Utils;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class TestFormWithOutLastName extends TestBase {
    Utils utils = new Utils();

    @Test
    @Tag("demoqa")
    void testFormWithOutLastName(){

        RegistrationDataModel testData = utils.generateDataForRegistration();

        new RegistrationPage()
                .openPage()
                .setFirstName(testData.firstName())
                .setGender(testData.gender())
                .setUserNumber(testData.userNumber())
                .setDayOfBirth(testData.year(), testData.month(), testData.day())
                .submit();

        new RegistrationPage()
                .checkInputBorderColor("Last Name")
                .checkTableIsHidden();
    }
}
