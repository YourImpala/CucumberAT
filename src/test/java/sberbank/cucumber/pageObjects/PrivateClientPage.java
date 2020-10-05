package sberbank.cucumber.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sberbank.cucumber.steps.Hooks;


public class PrivateClientPage {

    @FindBy(xpath = "//ul[@class='kitt-top-menu__list  kitt-top-menu__list_center']")
    WebElement navigation;


    public PrivateClientPage() {
        PageFactory.initElements(Hooks.getDriver(), this);

    }

    public void clickInNavigation(String menuItem) {
        navigation
                .findElement(By.xpath(".//label[@class = ' kitt-top-menu__link kitt-top-menu__link_first  '][contains(text(), '" + menuItem + "')]"))
                .click();
    }

    public void clickDropdownLink(String menuItem) {
        navigation
                .findElement(By.xpath(".//a[@class = 'kitt-top-menu__link kitt-top-menu__link_second'][contains(text(), '" + menuItem +"')]"))
                .click();
    }
}
