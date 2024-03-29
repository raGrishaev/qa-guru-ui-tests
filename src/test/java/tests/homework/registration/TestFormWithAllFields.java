package tests.homework.registration;

import config.TestBase;
import helpers.RegistrationDataModel;
import helpers.Utils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static io.qameta.allure.Allure.step;

@DisplayName("Проверка успешной регистрации с заполнением всех полей")
public class TestFormWithAllFields extends TestBase {
    Utils utils = new Utils();

    @Test
    @Tag("demoqa")
    void testFormWithAllFields(){
        RegistrationDataModel testData = utils.generateDataForRegistration();

        step("Открыть и заполнить всю форму регистрации", () -> {
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
        });

        step("Сверить заполняемые значения с полученными по итогам регистрации", () -> {
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
        });
    }
}
