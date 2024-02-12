package tests.homework.textbox;

import config.TestBase;
import helpers.TextBoxDataModel;
import helpers.Utils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

import static io.qameta.allure.Allure.step;

@DisplayName("Проверка заполнения формы TextBox")
public class TextBoxTestsNew extends TestBase {

    Utils utils = new Utils();
    @Test
    @Tag("demoqa")
    void fillFormTest() {

        TextBoxDataModel testData = utils.generateDataForTextBox();

        step("Открыть и заполнить форму всеми значениями", () -> {
            new TextBoxPage()
                    .openPage()
                    .setFullName(testData.fullName())
                    .setEmail(testData.email())
                    .setCurrentAddress(testData.currentAddress())
                    .setPermanentAddress(testData.permanentAddress())
                    .submit();
        });

        step("Сверить введённые результаты", () -> {
            new TextBoxPage()
                    .checkResult("Name", testData.fullName())
                    .checkResult("Email", testData.email())
                    .checkResult("Current Address", testData.currentAddress())
                    .checkResult("Permananet Address", testData.permanentAddress());
        });
    }
}
