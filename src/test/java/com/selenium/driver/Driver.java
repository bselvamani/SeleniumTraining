package com.selenium.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class Driver {

    private static final Logger logger = LoggerFactory.getLogger(Driver.class);

    public WebDriver driver;

    public String browser = "chrome";
    public String headless = "false";

    public void setupDriver() {
        try {
            if (browser == null || browser.isEmpty()) {
                logger.warn("Browser not specified, defaulting to Chrome");
                browser = "chrome";
            }

            if (browser.equalsIgnoreCase("firefox")) {
                logger.info("Setting up Firefox driver");
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver(setupFirefoxOption());
            } else if (browser.equalsIgnoreCase("chrome")) {
                logger.info("Setting up Chrome driver");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(setupChromeOption());
            } else {
                logger.error("Unsupported browser: " + browser);
                throw new IllegalArgumentException("Unsupported browser: " + browser);
            }

            // setup driver manage options
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            driver.manage().window().maximize();
            logger.info("Driver initialized successfully for browser: " + browser);
        } catch (Exception e) {
            logger.error("Failed to setup driver", e);
            throw new RuntimeException("Failed to setup driver", e);
        }
    }

    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    private ChromeOptions setupChromeOption() {
        ChromeOptions options = new ChromeOptions();
        if (headless.equalsIgnoreCase("true")) {
            options.addArguments("--headless=new");
        }
        return options;
    }

    private FirefoxOptions setupFirefoxOption() {
        FirefoxOptions options = new FirefoxOptions();
        if (headless.equalsIgnoreCase("true")) {
            options.addArguments("--headless");
        }
        return options;
    }
}
