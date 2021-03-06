package sberbank.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sberbank.GeneralMethods;
import sberbank.steps.Hooks;


public class ChoosePolicyTravelInsurancePage {

    @FindBy(xpath = "//div[contains(@class, 'online-card-program')]")
    WebElement card;


    @FindBy(xpath = "//button[@class='btn btn-primary btn-large']")
    WebElement takeOutInsuranceBtn;


    public ChoosePolicyTravelInsurancePage() {
        PageFactory.initElements(Hooks.getDriver(), this);
    }

    public boolean isSelected(String cardName) {
        return card
                .findElement(By.xpath("//h3[contains(text(), '" + cardName + "')]/parent::node()"))
                .getAttribute("class")
                .contains("selected");
    }

    public void selectCard(String cardName) {
        card
                .findElement(By.xpath("//h3[contains(text(), '" + cardName + "')]"))
                .click();
    }

    public void clicktakeOutInsuranceBtn() {
        GeneralMethods.moveToElementAndClick(Hooks.getDriver(), takeOutInsuranceBtn);
    }




}
