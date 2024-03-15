package org.example.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class InfoOfTourPage extends BasePage {

    @FindBy(xpath = "//div[@class=\"tour-sidebar\"]//button[contains(., 'Забронировать места')]")
    private WebElement buttonReserve;

    public InfoOfTourPage(WebDriver driver) {
        super(driver);
    }

    @Step("Переход на страницу бронирования тура")
    public InfoOfTourPage switchingToPageBookYourPlace() {
        Assert.assertTrue(buttonReserve.isDisplayed(), "Button number of tours is not displayed");
        buttonReserve.click();
        return this;
    }
}
