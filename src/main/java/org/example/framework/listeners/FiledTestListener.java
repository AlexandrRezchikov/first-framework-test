package org.example.framework.listeners;

import org.example.framework.common.CommonActions;
import org.example.framework.logger.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class FiledTestListener implements ITestListener {

    protected WebDriver driver = CommonActions.getDriver();

    @Override
    public void onTestFailure(ITestResult result) {
        ITestContext context = result.getTestContext();
        driver = (WebDriver) context.getAttribute("WebDriver");
        AllureLogger.saveScreenshotPNG(driver, "Test fail!");
        String methodName = result.getMethod().getConstructorOrMethod().getName();
        AllureLogger.attachLogToAllure(methodName + " failed and screenshot attached to the report!");
    }
}

