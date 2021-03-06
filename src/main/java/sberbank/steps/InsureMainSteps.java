package sberbank.steps;

import sberbank.pageObjects.InsureMainPage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class InsureMainSteps {
    private InsureMainPage insureMainPage;

    public InsureMainSteps(WebDriver driver) {
        this.insureMainPage = new InsureMainPage();
    }

    @Step("Нажать 'Оформить онлайн' в блоке 'Страхование путешественников'")
    public void applyOnlineInsurance() {
        insureMainPage.applyOnline();

    }

    @Step("Проверить открытие вкладки '{name}'")
    public void checkNewTab(String name) {
        Assertions.assertEquals(
                insureMainPage.isOpened(name),
                true
        );
    }
}
