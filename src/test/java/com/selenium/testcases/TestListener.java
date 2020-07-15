package com.selenium.testcases;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestListener extends TestListenerAdapter{

    @Override
    public void onTestFailure(ITestResult tr) {
        System.out.println("TEST METHOD FAILED: "+tr.getMethod().getMethodName() +" REASON:"+tr.getThrowable().getMessage());
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        System.out.println("TEST METHOD SKIPPED: "+tr.getMethod().getMethodName() +" REASON:"+tr.getThrowable().getMessage());
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
    }
}