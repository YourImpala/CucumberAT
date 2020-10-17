package sberbank.steps;

import sberbank.pageObjects.FormTravelInsurancePage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import sberbank.GeneralMethods;


import java.util.Map;

public class FormTravelInsuranceSteps {
    private WebDriver driver;
    private FormTravelInsurancePage formTravelInsurancePage;

    public FormTravelInsuranceSteps(WebDriver driver) {
        this.driver = driver;
        this.formTravelInsurancePage = new FormTravelInsurancePage();
    }

    @Step("Заполнить поля формы")
    public void fillFields(Map<String, String> fields) {
        fields.forEach((field, value) -> formTravelInsurancePage.fillFormField(field, value));

    }

    @Step("Проверить заполнение полей формы")
    public void checkFieldsFilling(Map<String, String> fieldsAndValues) {
        fieldsAndValues.forEach((key, value)->
                Assertions.assertEquals(
                        formTravelInsurancePage.getFormFieldValue(key),
                        value
                )
        );
        GeneralMethods.getScreenshot(driver);
    }

    @Step("Нажать кнопку 'продолжить'")
    public void clickContinueButton() {
        formTravelInsurancePage.clickContinueBtn();
    }

    @Step("Проверить собщение - {errorMessage}")
    public void checkErrorMessage(String errorMessage) {
        Assertions.assertEquals(
                formTravelInsurancePage.getErrorText(),
                errorMessage
        );
        GeneralMethods.moveToElement(driver, formTravelInsurancePage.getErrorMessage());
        GeneralMethods.getScreenshot(driver);
    }

}
