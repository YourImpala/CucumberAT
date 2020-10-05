package sberbank.cucumber;

import io.cucumber.datatable.DataTable;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class GeneralMethods {

    public static void fillField(WebElement locator, String value){
        locator.clear();
        locator.click();
        locator.sendKeys(value);
    }

    public static void moveToElementAndClick(WebDriver driver, WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).click(element);
        action.perform();
    }

    public static  void moveToElement(WebDriver driver, WebElement element) {
        Actions action = new Actions(driver);
        action
                .moveToElement(element)
                .build()
                .perform();
    }

    @Attachment
    public static byte[] getScreenshot(WebDriver driver){
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot,new File("src/main/resources/screen.png"));
            return Files.readAllBytes(Paths.get("src/main/resources","screen.png"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return new byte[0];
    }

    public static Map<String, String> getMapFromTable(DataTable table) {
        return table.asMap(String.class, String.class);
    }
}
