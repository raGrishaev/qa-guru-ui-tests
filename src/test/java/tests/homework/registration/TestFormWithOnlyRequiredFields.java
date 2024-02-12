package tests.homework.registration;

import config.TestBase;
import helpers.RegistrationDataModel;
import helpers.Utils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static io.qameta.allure.Allure.step;

@DisplayName("Проверка успешной регистрации с заполнением только обязательных полей")
public class TestFormWithOnlyRequiredFields extends TestBase {
    Utils utils = new Utils();

    @Test
    @Tag("demoqa")
    void testFormWithOutLastName(){
        RegistrationDataModel testData = utils.generateDataForRegistration();

        step("Открыть и заполнить форму регистрации толкьо обязательными полями", () -> {
            new RegistrationPage()
                    .openPage()
                    .setFirstName(testData.firstName())
                    .setLastName(testData.lastName())
                    .setGender(testData.gender())
                    .setUserNumber(testData.userNumber())
                    .setDayOfBirth(testData.year(), testData.month(), testData.day())
                    .submit();
        });

        step("Сверить заполняемые значения с полученными по итогам регистрации", () -> {
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
        });
    }
}
