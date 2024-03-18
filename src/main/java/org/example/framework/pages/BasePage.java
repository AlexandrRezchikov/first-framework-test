package org.example.framework.pages;

import io.qameta.allure.Step;
import org.example.framework.constants.Constant;
import org.example.framework.utils.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        AllureLogger.info("Init");
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Open URL")
    public void open(String url) {
        AllureLogger.debug("Open url");
        driver.get(url);
    }

    protected WebElement waitElementIsVisible(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(Constant.TimeoutVariable.EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOf(element));
        return element;
    }
}
