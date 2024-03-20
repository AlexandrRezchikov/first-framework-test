package org.example.framework.listeners;

import org.example.framework.common.CommonDriverActions;
import org.example.framework.logger.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class FiledTestListener implements ITestListener {

    protected WebDriver driver;

    @Override
    public void onTestFailure(ITestResult result) {
        ITestContext context = result.getTestContext();
        driver = (WebDriver) context.getAttribute("WebDriver");
        AllureLogger.saveScreenshotPNG(CommonDriverActions.getDriver(), "Test failed!");
        String methodName = result.getMethod().getConstructorOrMethod().getName();
        AllureLogger.attachLogToAllure(methodName + " failed and screenshot attached to the report!");
    }
}

