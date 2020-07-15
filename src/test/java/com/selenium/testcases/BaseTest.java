package com.selenium.testcases;

import com.selenium.driver.Driver;
import com.selenium.helper.Project;
import com.selenium.pom.HomePage;
import com.selenium.pom.LoginPage;
import com.selenium.pom.MyAccountPage;

import org.testng.annotations.*;
import org.apache.log4j.Logger;

public class BaseTest extends Driver {

    protected final Logger logger = Logger.getLogger(BaseTest.class);

    protected HomePage homePage;
    protected LoginPage loginPage;
    protected MyAccountPage myAccountPage;

    @BeforeSuite
    public void beforeSuite() throws Exception {
        if (System.getProperty("browser") != null)
            browser = System.getProperty("browser");
        if (System.getProperty("headless") != null)
            headless = System.getProperty("headless");
    }

    @BeforeTest
    public void beforeTest() throws Exception {
        logger.info("Setting up selenium driver ...");
        setupDriver();
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        logger.info("Closing selenium driver ...");
        closeDriver();
    }
}
