package org.example.tests;

import org.example.common.CommonActions;
import org.example.pages.ApplicationForTourPage;
import org.example.pages.InfoOfTourPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.example.pages.BasePage;
import org.example.pages.FiltersForSearchPage;
import org.example.pages.MainPage;

import static org.example.common.Config.CLEAR_COOKIES_AND_STORAGE;
import static org.example.common.Config.HOLD_BROWSER_OPEN;

public class BaseTest {

    public WebDriver driver;
    protected BasePage basePage;
    protected MainPage mainPage;
    protected FiltersForSearchPage filtersForSearchPage;
    protected InfoOfTourPage infoOfTour;
    protected ApplicationForTourPage applicationForTourPage;

    @BeforeMethod
    public void setUp() {
        driver = CommonActions.createDriver();
        basePage = new BasePage(driver);
        mainPage = new MainPage(driver);
        filtersForSearchPage = new FiltersForSearchPage(driver);
        infoOfTour = new InfoOfTourPage(driver);
        applicationForTourPage = new ApplicationForTourPage(driver);
    }

    @AfterMethod
    public void clearCookiesAndLocalStorage() {
        if (CLEAR_COOKIES_AND_STORAGE) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }

    @AfterMethod(alwaysRun = true)
    public void close() {
        if (HOLD_BROWSER_OPEN) {
            driver.quit();
        }
    }
}
