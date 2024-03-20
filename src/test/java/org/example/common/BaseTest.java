package org.example.common;

import org.example.framework.common.CommonActions;
import org.example.framework.pages.ApplicationForTourPage;
import org.example.framework.pages.InfoOfTourPage;
import org.example.framework.logger.AllureLogger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.example.framework.pages.BasePage;
import org.example.framework.pages.FiltersForSearchPage;
import org.example.framework.pages.MainPage;

import static org.example.framework.config.Config.CLEAR_COOKIES_AND_STORAGE;
import static org.example.framework.config.Config.HOLD_BROWSER_OPEN;

public class BaseTest {

    public WebDriver driver;
    protected BasePage basePage;
    protected MainPage mainPage;
    protected FiltersForSearchPage filtersForSearchPage;
    protected InfoOfTourPage infoOfTour;
    protected ApplicationForTourPage applicationForTourPage;

    @BeforeMethod
    public void setUp(ITestContext context) {
        driver = CommonActions.getDriver();
        AllureLogger.info("Set Up");
        context.setAttribute("WebDriver", CommonActions.getDriver());
        basePage = new BasePage();
        mainPage = new MainPage();
        filtersForSearchPage = new FiltersForSearchPage();
        infoOfTour = new InfoOfTourPage();
        applicationForTourPage = new ApplicationForTourPage();
    }

    @AfterMethod
    public void clearCookiesAndLocalStorage() {
        AllureLogger.info("Clear cookies and local storage");
        if (CLEAR_COOKIES_AND_STORAGE) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) CommonActions.getDriver();
            CommonActions.getDriver().manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }

    @AfterMethod(alwaysRun = true)
    public void close() {
        AllureLogger.info("Close");
        if (HOLD_BROWSER_OPEN) {
            CommonActions.getDriver().quit();
        }
    }
}
