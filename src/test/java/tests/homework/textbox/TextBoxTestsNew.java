package tests.homework.textbox;

import config.TestBase;
import helpers.TextBoxDataModel;
import helpers.Utils;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

import static io.qameta.allure.Allure.step;

public class TextBoxTestsNew extends TestBase {

    Utils utils = new Utils();
    @Test
    @Tag("demoqa")
    void fillFormTest() {

        TextBoxDataModel testData = utils.generateDataForTextBox();

        step("Open and fill form", () -> {
            new TextBoxPage()
                    .openPage()
                    .setFullName(testData.fullName())
                    .setEmail(testData.email())
                    .setCurrentAddress(testData.currentAddress())
                    .setPermanentAddress(testData.permanentAddress())
                    .submit();
        });

        step("Verify results", () -> {
            new TextBoxPage()
                    .checkResult("Name", testData.fullName())
                    .checkResult("Email", testData.email())
                    .checkResult("Current Address", testData.currentAddress())
                    .checkResult("Permananet Address", testData.permanentAddress());
        });
    }
}
