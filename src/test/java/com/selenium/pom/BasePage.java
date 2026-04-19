package com.selenium.pom;

import com.selenium.helper.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class BasePage {
    private static final Logger logger = LoggerFactory.getLogger(BasePage.class);
    
    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        logger.debug("BasePage initialized");
    }

    public void openURL() {
        String url = Config.getInstance().url();
        if (url == null || url.isEmpty()) {
            logger.error("URL is not configured in properties");
            throw new IllegalArgumentException("URL is not configured");
        }
        logger.info("Opening URL: " + url);
        driver.get(url);
    }

    public WebDriverWait waitFor(long seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds));
    }
}