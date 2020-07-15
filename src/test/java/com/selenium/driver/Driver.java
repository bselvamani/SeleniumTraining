package com.selenium.driver;

import com.selenium.helper.Project;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class Driver {

    public WebDriver driver;

    public String browser = "chrome";
    public String headless = "false";

    public void setupDriver() {
        // get remote driver
        String driver_path = Project.ROOT + "/src/test/resources/selenium";

        if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", driver_path + "/geckodriver");
            driver = new FirefoxDriver(setupFirefoxOption());
        } else if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", driver_path + "/chromedriver");
            driver = new ChromeDriver(setupChromeOption());
        }

        // setup driver manage options
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    private ChromeOptions setupChromeOption() {
        ChromeOptions options = new ChromeOptions();
        if (headless.equalsIgnoreCase("true"))
            options.setHeadless(true);
        else
            options.setHeadless(false);
        return options;
    }

    private FirefoxOptions setupFirefoxOption() {
        FirefoxOptions options = new FirefoxOptions();
        if (headless.equalsIgnoreCase("true"))
            options.setHeadless(true);
        else
            options.setHeadless(false);
        return options;
    }
}
