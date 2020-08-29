package sberbank.cucumber.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sberbank.cucumber.settings.WebDriverSettings;

public class TravelInsurancePage {
    WebDriver driver;

    @FindBy(xpath = "//div[contains(@class, 'kit-col_lg-top_40')]/h1")
    WebElement travelInsuranceTitle;

    @FindBy(xpath = "//div[@class='product-teaser-full-width__button']")
    WebElement issueOnlineButton;


    public TravelInsurancePage() {
        PageFactory.initElements(WebDriverSettings.getDriver(), this);
    }

    public boolean checkTravelInsuranceTitle(String titleName) {
        return travelInsuranceTitle.getText().equals(titleName);
    }


    public void clickIssueOnlineButton() {
        issueOnlineButton.click();
    }
}
