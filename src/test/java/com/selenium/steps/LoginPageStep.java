package com.selenium.steps;

import static org.testng.AssertJUnit.assertTrue;

import com.selenium.helper.Config;
import com.selenium.pom.HomePage;
import com.selenium.pom.MyAccountPage;
import com.selenium.pom.LoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageStep {

	public HomePage homePage;
	public LoginPage loginPage;
	public MyAccountPage myAccountPage;

	@Given("^I am on the Home page$")
	public void i_am_on_home_page() throws Throwable {

		homePage =  new HomePage(BaseTest.wDriver);
		assertTrue(homePage.isInitialized());
	}

	@And("^I navigate to Sign in page$")
	public void i_navigate_to_signin_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		loginPage = homePage.onClicklogin();
		assertTrue(loginPage.isInitialized());
	}

	@When("^I click on Sign in button with credential$")
	public void i_click_on_signin_button_with_credential() throws Throwable {
		myAccountPage = loginPage.onClickSignIn(Config.getInstance().user(), Config.getInstance().password());
	}

	@Then("^I should see My Account page$")
	public void i_should_see_myaccount_page() throws Throwable {
		assertTrue(myAccountPage.isInitialized());
	}
}