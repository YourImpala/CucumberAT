package sberbank.cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import io.cucumber.datatable.DataTable;
import sberbank.cucumber.GeneralMethods;

public class CucumberSteps {

    PrivateClientSteps privateClientSteps;
    InsureMainSteps insureMainSteps;
    TravelIsuranceSteps travelIsuranceSteps;
    ChoosePolicyTravelInsuranceSteps choosePolicyTravelInsuranceSteps;
    FormTravelInsuranceSteps formTravelInsuranceSteps;

    @Когда("перешел на сайт '(.*)'")
    public void перейти_на_сайт(String url) {
        Hooks.getDriver().get(url);

        privateClientSteps = new PrivateClientSteps(Hooks.getDriver());
        insureMainSteps = new InsureMainSteps(Hooks.getDriver());
        travelIsuranceSteps = new TravelIsuranceSteps();
        choosePolicyTravelInsuranceSteps = new ChoosePolicyTravelInsuranceSteps(Hooks.getDriver());
        formTravelInsuranceSteps = new FormTravelInsuranceSteps(Hooks.getDriver());

    }

    @Тогда("нажать на пункт навигации '(.*)'")
    public void нажать_на_пункт_навигации(String navItemName) {
        privateClientSteps.selectInNavigationMenu(navItemName);
    }

    @Тогда("нажать на пункт выпадающего меню '(.*)'")
    public void нажать_на_пункт_выпадающего_меню(String dropdownItemName) {
        privateClientSteps.selectInDropdownMenu(dropdownItemName);
    }

    @Когда("нажал на кнопку 'оформить онлайн' в блоке страховки")
    public void нажать_на_оформить_онлайн() {
        insureMainSteps.applyOnlineInsurance();
    }

    @Тогда("проверить открытие вкладки '(.*)'")
    public void проверить_открытие_вкладки(String pageTitleName) {
        insureMainSteps.checkNewTab(pageTitleName);
    }

    @Когда("на странице присутствует заголовок '(.*)'")
    public void проверить_наличие_на_странице_заголовка(String titleName) {
        travelIsuranceSteps.checkTitle(titleName);
    }

    @Тогда("нажать на кнопку Оформить Онлайн")
    public void нажать_на_кнопку_оформить_онлайн() throws InterruptedException {
        travelIsuranceSteps.clickIssueOnlineButton();
    }

    @Когда("выбран пакет страховки - '(.*)'")
    public void выбрать_полис(String policyType) {
        choosePolicyTravelInsuranceSteps.selectInsuranceType(policyType);
    }

    @Тогда("проверить выбор пакета страховки - '(.*)'")
    public void провенить_выбор_полиса(String policyType) {
        choosePolicyTravelInsuranceSteps.checkSelectedInsurance(policyType);
    }

    @Тогда("нажать кнопку Оформить")
    public void нажать_кнопку_оформить() {
        choosePolicyTravelInsuranceSteps.clickArrangeButton();
    }

    @Когда("заполнены поля формы")
    public void заполнить_форму(DataTable fieldsAndValues) {
        formTravelInsuranceSteps.fillFields(GeneralMethods.getMapFromTable(fieldsAndValues));
    }

    @Тогда("Проверить заполнение полей")
    public void роверить_заполние_полей(DataTable fieldsAndValues) {
        formTravelInsuranceSteps.checkFieldsFilling(GeneralMethods.getMapFromTable(fieldsAndValues));
    }

    @Тогда("нажать кнопку продолжить")
    public void нажать_кнопку_продолжить() {
        formTravelInsuranceSteps.clickContinueButton();
    }

    @И("проверить сообщение об ошибке - '(.*)'")
    public void проверить_сообщение_об_ошибке(String errorText) {
        formTravelInsuranceSteps.checkErrorMessage(errorText);
    }
}
