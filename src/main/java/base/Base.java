package base;

import config.Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


public class Base {

    public static WebDriver driver;
    public static Properties prop;

    public Base(){
        prop = Config.loadProperties();
    }


    @BeforeTest
    public void initDriver(@Optional("firefox") String browser) {
        if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }else if (browser.equalsIgnoreCase("safari")){
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        }
//        wait = new WebDriver(driver, Long.parseLong(prop.getProperty("driver_timeout")));
//        flWait = new FluentWait<>(driver)
//                .withTimeout(Duration.ofSeconds(Long.parseLong("driver_polling_interval")));

        driver.get(Base.getURL());
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        }
    public static void tearDown(){
        driver.quit();

        if(!(driver instanceof FirefoxDriver)){
            driver.quit();
        }
    }
    public static String getURL(){
        String url = "";
        if(prop != null){
            url = prop.getProperty("url");
        }
        return url;
    }

    public String getTextFromElement(WebElement element){
        String text = "";
        text = element.getText();

        if (text.equals("")){
            text = element.getAttribute("innerHTML");
        }
        return text;
    }


}