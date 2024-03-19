package org.example.framework.pages;

import io.qameta.allure.Step;
import org.example.framework.logger.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.example.framework.config.Config.EXPLICIT_WAIT;

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
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOf(element));
        return element;
    }
}
