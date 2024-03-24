package org.example.framework.listeners;

import org.example.framework.logger.AllureLogger;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class FiledTestListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult result) {
        AllureLogger.saveScreenshotPNG("Test failed!");
        String methodName = result.getMethod().getConstructorOrMethod().getName();
        AllureLogger.attachLogToAllure(methodName + " failed and screenshot attached to the report!");
    }
}

