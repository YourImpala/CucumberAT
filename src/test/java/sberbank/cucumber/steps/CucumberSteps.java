package sberbank.cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;
import sberbank.cucumber.GeneralMethods;
import sberbank.cucumber.settings.WebDriverSettings;


public class CucumberSteps extends WebDriverSettings {

    PrivateClientSteps privateClientSteps = new PrivateClientSteps(driver);
    TravelIsuranceSteps travelIsuranceSteps = new TravelIsuranceSteps();
    ChoosePolicyTravelInsuranceSteps choosePolicyTravelInsuranceSteps = new ChoosePolicyTravelInsuranceSteps(driver);
    FormTravelInsuranceSteps formTravelInsuranceSteps = new FormTravelInsuranceSteps(driver);

    @Given("Перейти на сайт '(.*)'")
    public void перейти_на_сайт(String url) {
        startBrowser();
        driver.get(url);
    }

    @Then("Нажать на пункт навигации '(.*)'")
    public void нажать_на_пункт_навигации(String navItemName) {
        privateClientSteps.selectInNavigationMenu(navItemName);
    }

    @Then("Нажать на пункт выпадающего меню '(.*)'")
    public void нажать_на_пункт_выпадающего_меню(String dropdownItemName) {
        privateClientSteps.selectInDropdownMenu(dropdownItemName);
    }

    @Then("Проверить наличие на странице заголовка '(.*)'")
    public void проверить_наличие_на_странице_заголовка(String titleName) {
        travelIsuranceSteps.checkTitle(titleName);
    }

    @Then("Нажать на кнопку Оформить Онлайн")
    public void нажать_на_кнопку_оформить_онлайн() {
        travelIsuranceSteps.clickIssueOnlineButton();
    }

    @Then("Выбрать полис - '(.*)'")
    public void выбрать_полис(String policyType) {
        choosePolicyTravelInsuranceSteps.selectInsuranceType(policyType);
    }

    @Then("Проверить выбор полиса - '(.*)'")
    public void провенить_выбор_полиса(String policyType) {
        choosePolicyTravelInsuranceSteps.checkSelectedInsurance(policyType);
    }

    @Then("Нажать кнопку Оформить")
    public void нажать_кнопку_оформить() {
        choosePolicyTravelInsuranceSteps.clickArrangeButton();
    }

    @Then("Заполнить поля формы")
    public void заполнить_форму(DataTable fieldsAndValues) {
        formTravelInsuranceSteps.fillFields(GeneralMethods.getMapFromTable(fieldsAndValues));
    }

    @Then("Проверить заполнение полей")
    public void роверить_заполние_полей(DataTable fieldsAndValues) {
        formTravelInsuranceSteps.checkFieldsFilling(GeneralMethods.getMapFromTable(fieldsAndValues));
    }

    @Then("Нажать кнопку продолжить")
    public void нажать_кнопку_продолжить() {
        formTravelInsuranceSteps.clickContinueButton();
    }

    @Then("Проверить сообщение об ошибке - '(.*)'")
    public void проверить_сообщение_об_ошибке(String errorText) {
        formTravelInsuranceSteps.checkErrorMessage(errorText);
    }
}
