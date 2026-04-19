package com.selenium.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage extends BasePage {
    
    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);
    
    @FindBy(css = "[data-qa='login-email']")
    private WebElement txtEmailAddress;
    
    @FindBy(css = "[data-qa='login-password']")
    private WebElement txtPassword;
    
    @FindBy(css = "[data-qa='login-button']")
    private WebElement btnSignin;

    public LoginPage(WebDriver driver) {
        super(driver);
        logger.debug("LoginPage object created");
    }
    
    public boolean isInitialized() {
        wait.until(ExpectedConditions.visibilityOf(this.btnSignin));
        boolean isDisplayed = btnSignin.isDisplayed();
        logger.debug("LoginPage initialization status: " + isDisplayed);
        return isDisplayed;
    }

    public MyAccountPage onClickSignIn(String email, String pwd) {
        if (email == null || email.isEmpty() || pwd == null || pwd.isEmpty()) {
            logger.error("Email or password is empty");
            throw new IllegalArgumentException("Email and password cannot be empty");
        }
        logger.info("Entering login credentials");
        this.txtEmailAddress.sendKeys(email);
        this.txtPassword.sendKeys(pwd);
        this.btnSignin.click();
        logger.info("Sign in button clicked");
        return new MyAccountPage(driver);
    }
}
