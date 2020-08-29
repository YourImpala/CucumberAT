package sberbank.cucumber.steps;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import sberbank.cucumber.GeneralMethods;
import sberbank.cucumber.pageObjects.TravelInsurancePage;
import sberbank.cucumber.settings.WebDriverSettings;

public class TravelIsuranceSteps {

    private TravelInsurancePage travelInsurancePage;

    public TravelIsuranceSteps() {
        this.travelInsurancePage = new TravelInsurancePage();
    }

    @Step("Наличие на странице заголовка – {titleText}")
    public void checkTitle(String titleText) {
        if(travelInsurancePage.checkTravelInsuranceTitle(titleText)) {
            Assertions.assertTrue(true);
        } else {
            GeneralMethods.getScreenshot(WebDriverSettings.getDriver());
            Assertions.assertTrue(false, "Заголовок - " + titleText + " не найден");
        }
    }

    @Step("Нажать кнопку 'Оформить онлайн'")
    public void clickIssueOnlineButton() {
        travelInsurancePage.clickIssueOnlineButton();
    }
}
