package org.example.common;

import org.example.framework.common.DriverActions;
import org.example.framework.listeners.FiledTestListener;
import org.example.framework.logger.AllureLogger;
import org.example.framework.pages.AllPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import static org.example.framework.config.Config.CLEAR_COOKIES_AND_STORAGE;
import static org.example.framework.config.Config.HOLD_BROWSER_OPEN;

@Listeners({FiledTestListener.class})
public class BaseTest extends AllPages {

    public WebDriver driver;

    @BeforeMethod
    public void setUp(ITestContext context) {
        driver = DriverActions.getDriver();
        AllureLogger.info("Set Up");
        context.setAttribute("WebDriver", DriverActions.getDriver());
        AllPages.init();
    }

    @AfterMethod
    public void clearCookiesAndLocalStorage() {
        if (CLEAR_COOKIES_AND_STORAGE) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) DriverActions.getDriver();
            DriverActions.getDriver().manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }

    @AfterMethod(alwaysRun = true)
    public void close() {
        if (HOLD_BROWSER_OPEN) {
            DriverActions.quit();
        }
    }

}
