package sberbank.cucumber.steps;

import cucumber.api.java.Before;
import cucumber.api.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import sberbank.cucumber.settings.TestProperties;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Hooks {
    public static WebDriver driver;
    public static Properties properties = TestProperties.getInstance().getProperties();
    public static String baseURL;

    public static WebDriver getDriver(){
        return driver;
    }
    @Before
    public void startBrowser(){
        switch (properties.getProperty("browser")){
            case "firefox":
                System.setProperty("webdriver.gecko.driver", properties.getProperty("webdriver.gecko.driver"));
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        baseURL = properties.getProperty("app.url");

    }

    @After
    public static void tearDown() throws Exception {
        driver.quit();
    }
}
