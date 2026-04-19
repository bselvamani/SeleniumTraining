package com.selenium.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends BasePage {
    
    private static final Logger logger = LoggerFactory.getLogger(HomePage.class);
    
    @FindBy(linkText = "Contact us")
    private WebElement lnkContactUs;
    
    @FindBy(linkText = "Signup / Login")
    private WebElement lnkSignIn;

    public HomePage(WebDriver driver) {
        super(driver);
        openURL();
        logger.debug("HomePage object created");
    }
    
    public boolean isInitialized() {
        wait.until(ExpectedConditions.visibilityOf(this.lnkSignIn));
        boolean isDisplayed = lnkSignIn.isDisplayed();
        logger.debug("HomePage initialization status: " + isDisplayed);
        return isDisplayed;
    }
    
    public LoginPage onClicklogin() {
        logger.info("Clicking on login link");
        wait.until(ExpectedConditions.elementToBeClickable(this.lnkSignIn));
        this.lnkSignIn.click();
        return new LoginPage(driver);
    }

}
