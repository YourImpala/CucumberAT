package sberbank.cucumber.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import sberbank.cucumber.pageObjects.PrivateClientPage;


public class PrivateClientSteps {

    private PrivateClientPage privateClientPage;

    public PrivateClientSteps(WebDriver driver) {
        this.privateClientPage = new PrivateClientPage();
    }

    @Step("Нажать '{menuItem}' в меню навигации")
    public void selectInNavigationMenu(String menuItem) {
        privateClientPage.clickInNavigation(menuItem);
    }

    @Step("Нажать '{dropDownMenuItem}' в выпадающем меню")
    public void selectInDropdownMenu(String dropDownMenuItem) {
        privateClientPage.clickDropdownLink(dropDownMenuItem);
    }
}
