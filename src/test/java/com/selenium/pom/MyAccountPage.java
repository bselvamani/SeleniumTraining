package com.selenium.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyAccountPage extends BasePage {
    
    private static final Logger logger = LoggerFactory.getLogger(MyAccountPage.class);
    
    @FindBy(linkText = "Delete Account")
    private WebElement lnkMyAccount;

    public MyAccountPage(WebDriver driver) {
        super(driver);
        logger.debug("MyAccountPage object created");
    }
    
    public boolean isInitialized() {
        wait.until(ExpectedConditions.visibilityOf(this.lnkMyAccount));
        boolean isDisplayed = lnkMyAccount.isDisplayed();
        logger.debug("MyAccountPage initialization status: " + isDisplayed);
        return isDisplayed;
    }
}
