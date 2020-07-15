package com.selenium.testcases;

import static org.testng.AssertJUnit.assertTrue;

import com.selenium.helper.Config;
import com.selenium.pom.HomePage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test
    public void test_myAccountPage() {

        homePage = new HomePage(driver);
        assertTrue(homePage.isInitialized());

        loginPage = homePage.onClicklogin();
        assertTrue(loginPage.isInitialized());

        myAccountPage = loginPage.onClickSignIn(Config.getInstance().user(), Config.getInstance().password());
        assertTrue(myAccountPage.isInitialized());
    }

    @Test(enabled = false)
    public void test_myAccountPage1() {
        driver.get(Config.getInstance().url());
        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys(Config.getInstance().user());
        driver.findElement(By.id("passwd")).sendKeys(Config.getInstance().password());

        assertTrue(driver.findElement(By.linkText("My account")).isDisplayed());
    }
}