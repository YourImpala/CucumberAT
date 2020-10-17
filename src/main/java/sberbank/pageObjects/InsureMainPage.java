package sberbank.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sberbank.steps.Hooks;

import java.util.ArrayList;


public class InsureMainPage {
    private final WebDriver driver;

    @FindBy(xpath = "//h2[contains(text(),'Страхование путешественников')]/parent::div")
    WebElement travelInsuranceBlock;

    public InsureMainPage() {
        this.driver = Hooks.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void applyOnline() {
        travelInsuranceBlock
                .findElement(By.xpath(".//div[@class='rt-button']"))
                .click();
    }

    public boolean isOpened(String pageTitle) {
        ArrayList tabs = new ArrayList (driver.getWindowHandles());
        driver.switchTo().window((String) tabs.get(1));

        new WebDriverWait(driver, 40)
                .until(ExpectedConditions.titleIs(pageTitle));

        return driver.getTitle().equals(pageTitle);
    }
}
