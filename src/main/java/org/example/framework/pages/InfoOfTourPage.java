package org.example.framework.pages;

import io.qameta.allure.Step;
import org.example.framework.logger.AllureLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class InfoOfTourPage extends BasePage {

    @FindBy(xpath = "//div[@class=\"tour-sidebar\"]//button[contains(., 'Забронировать места')]")
    private WebElement buttonReserve;

    @Step("Переход на страницу бронирования тура")
    public InfoOfTourPage switchingToPageBookYourPlace() {
        AllureLogger.debug("Go to page book your place");
        Assert.assertTrue(buttonReserve.isDisplayed(), "Button number of tours is not displayed");
        buttonReserve.click();
        return this;
    }
}
