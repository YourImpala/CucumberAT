package sberbank.cucumber.pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sberbank.cucumber.steps.Hooks;

import java.util.List;
import java.util.stream.Collectors;


public class TravelInsurancePage {
    WebDriver driver;
    @FindBy(xpath = "//h1[@class='s-hero-banner__title']")
    List<WebElement> travelInsuranceTitles;

    @FindBy(xpath = "//a[@class='s-btn'][contains(text(),'Оформить онлайн')]")
    WebElement applyOnlineBtn;


    public TravelInsurancePage() {
        this.driver = Hooks.getDriver();
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getTitles(String title) {
        return travelInsuranceTitles.stream()
                .filter(t -> t.getText().equals(title))
                .collect(Collectors.toList());
    }

    public void clickApplyOnline(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", applyOnlineBtn);

        try{
            applyOnlineBtn.click();
        }catch (WebDriverException e){
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", applyOnlineBtn);
        }
    }
}
