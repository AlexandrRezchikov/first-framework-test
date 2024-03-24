package org.example.framework.pages;

import io.qameta.allure.Step;
import org.example.framework.common.DriverActions;
import org.example.framework.logger.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.example.framework.config.Config.EXPLICIT_WAIT;

public class BasePage {

    public WebDriver driver;

    public BasePage() {
        AllureLogger.info(String.format("Init %s page", this.getClass().getSimpleName()));
        this.driver = DriverActions.getDriver();
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

    protected WebElement waitTextToBePresentInElement(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT))
                .until(ExpectedConditions.textToBePresentInElement(element, "Найден"));
        return element;
    }

    protected WebElement waitElementToBeClickable(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT))
                .until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }
}
