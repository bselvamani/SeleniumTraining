package com.selenium.steps;

import com.selenium.driver.Driver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BaseTest extends Driver {

    private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    public static WebDriver wDriver;

    @Before
    public void setUp() throws Exception {
        logger.info("Setting up driver for Cucumber scenario");
        browser = "chrome";
        headless = "false";

        setupDriver();
        wDriver = driver;
    }

    @After
    public void embedScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            logger.error("Scenario failed: " + scenario.getName());
            try {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Failed Scenario Screenshot");
                logger.info("Screenshot captured for failed scenario");
            } catch (WebDriverException e) {
                logger.error("Failed to capture screenshot: " + e.getMessage());
            }
        }
        logger.info("Closing driver after scenario: " + scenario.getName());
        closeDriver();
    }
}
