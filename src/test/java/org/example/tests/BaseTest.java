package org.example.tests;

import org.example.framework.common.CommonActions;
import org.example.framework.pages.ApplicationForTourPage;
import org.example.framework.pages.InfoOfTourPage;
import org.example.framework.utils.AllureLogger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.example.framework.pages.BasePage;
import org.example.framework.pages.FiltersForSearchPage;
import org.example.framework.pages.MainPage;

import static org.example.framework.common.Config.CLEAR_COOKIES_AND_STORAGE;
import static org.example.framework.common.Config.HOLD_BROWSER_OPEN;

public class BaseTest {

    public WebDriver driver;
    protected BasePage basePage;
    protected MainPage mainPage;
    protected FiltersForSearchPage filtersForSearchPage;
    protected InfoOfTourPage infoOfTour;
    protected ApplicationForTourPage applicationForTourPage;

    @BeforeMethod
    public void setUp(ITestContext context) {
        AllureLogger.info("Set Up");
        driver = CommonActions.createDriver();
        context.setAttribute("WebDriver", driver);
        basePage = new BasePage(driver);
        mainPage = new MainPage(driver);
        filtersForSearchPage = new FiltersForSearchPage(driver);
        infoOfTour = new InfoOfTourPage(driver);
        applicationForTourPage = new ApplicationForTourPage(driver);
    }

    @AfterMethod
    public void clearCookiesAndLocalStorage() {
        AllureLogger.info("Clear cookies and local storage");
        if (CLEAR_COOKIES_AND_STORAGE) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }

    @AfterMethod(alwaysRun = true)
    public void close() {
        AllureLogger.info("Close");
        if (HOLD_BROWSER_OPEN) {
            driver.quit();
        }
    }
}
