package com.selenium.testcases;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestListener extends TestListenerAdapter{

    private static final Logger logger = LoggerFactory.getLogger(TestListener.class);

    @Override
    public void onTestFailure(ITestResult tr) {
        logger.error("TEST METHOD FAILED: " + tr.getMethod().getMethodName() + " REASON: " + tr.getThrowable().getMessage(), tr.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        logger.warn("TEST METHOD SKIPPED: " + tr.getMethod().getMethodName() + " REASON: " + (tr.getThrowable() != null ? tr.getThrowable().getMessage() : "Unknown"));
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        logger.info("TEST METHOD PASSED: " + tr.getMethod().getMethodName());
    }
}