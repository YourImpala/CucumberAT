package sberbank.cucumber.steps;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import sberbank.cucumber.GeneralMethods;
import sberbank.cucumber.pageObjects.TravelInsurancePage;

import java.util.List;

public class TravelIsuranceSteps {

    private TravelInsurancePage travelInsurancePage;

    public TravelIsuranceSteps() {
        this.travelInsurancePage = new TravelInsurancePage();
    }

    @Step("Наличие на странице заголовка – {titleText}")
    public void checkTitle(String titleText) {
        List<WebElement> titles = travelInsurancePage.getTitles(titleText);
        if(titles.size() >= 1) {
            Assertions.assertTrue(true);
        } else {
            GeneralMethods.getScreenshot(Hooks.getDriver());
            Assertions.assertTrue(false, "Заголовок - " + titleText + " не найден");
        }
    }

    @Step("Нажать кнопку 'Оформить онлайн'")
    public void clickIssueOnlineButton() {
        travelInsurancePage.clickApplyOnline();
    }
}
