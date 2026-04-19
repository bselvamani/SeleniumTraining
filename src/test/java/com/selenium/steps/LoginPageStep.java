package com.selenium.steps;

import static org.testng.AssertJUnit.assertTrue;

import com.selenium.helper.Config;
import com.selenium.pom.HomePage;
import com.selenium.pom.MyAccountPage;
import com.selenium.pom.LoginPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageStep {

    private static final Logger logger = LoggerFactory.getLogger(LoginPageStep.class);
    
    public HomePage homePage;
    public LoginPage loginPage;
    public MyAccountPage myAccountPage;

    @Given("^I am on the Home page$")
    public void i_am_on_home_page() throws Throwable {
        logger.info("Navigating to home page");
        homePage = new HomePage(BaseTest.wDriver);
        assertTrue(homePage.isInitialized());
        logger.info("Home page initialized successfully");
    }

    @And("^I navigate to Sign in page$")
    public void i_navigate_to_signin_page() throws Throwable {
        logger.info("Navigating to sign in page");
        loginPage = homePage.onClicklogin();
        assertTrue(loginPage.isInitialized());
        logger.info("Sign in page initialized successfully");
    }

    @When("^I click on Sign in button with credential$")
    public void i_click_on_signin_button_with_credential() throws Throwable {
        logger.info("Clicking sign in button with credentials");
        myAccountPage = loginPage.onClickSignIn(Config.getInstance().user(), Config.getInstance().password());
        logger.info("Sign in completed");
    }

    @Then("^I should see My Account page$")
    public void i_should_see_myaccount_page() throws Throwable {
        logger.info("Verifying my account page");
        assertTrue(myAccountPage.isInitialized());
        logger.info("My account page verified successfully");
    }
}