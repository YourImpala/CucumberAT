package sberbank.cucumber.steps;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import sberbank.cucumber.pageObjects.ChoosePolicyTravelInsurancePage;


public class ChoosePolicyTravelInsuranceSteps {
    private ChoosePolicyTravelInsurancePage choosePolicyTravelInsurancePage;

    public ChoosePolicyTravelInsuranceSteps(WebDriver driver) {
        this.choosePolicyTravelInsurancePage = new ChoosePolicyTravelInsurancePage();
    }

    @Step("Выбрать страховку - {insuranceType}")
    public void selectInsuranceType(String insuranceType) {
        choosePolicyTravelInsurancePage.selectCard(insuranceType);
    }

    @Step("Проверить что выбрана страховка - {insuranceType}")
    public void checkSelectedInsurance(String insuranceType) {
        Assertions.assertTrue(
                choosePolicyTravelInsurancePage.isSelected(insuranceType)
        );
    }

    @Step("Нажать кнопку 'Оформить'")
    public void clickArrangeButton() {
        choosePolicyTravelInsurancePage.clicktakeOutInsuranceBtn();
    }

}
