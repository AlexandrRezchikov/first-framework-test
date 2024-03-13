package org.example.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MainPage extends BasePage {

    @FindBy(xpath = "//input[@placeholder=\"Введите регион, место или тур\" and @name=\"search\"]")
    private WebElement textBarRegion;

    @FindBy(xpath = "//div[@class='search-filters-dropdown']//a[@href=\"/kareliya\"]")
    private WebElement searchResultRegion;

    @FindBy(xpath = "//input[@placeholder='Любой']")
    private WebElement textBarVieRecreation;

    @FindBy(xpath = "//li[@data-id=\"15\" and @data-type=\"rest_kinds\"]")
    private WebElement viewRecreation;

    @FindBy(xpath = "//input[@placeholder=\"Любые\"]")
    private WebElement textBarDate;

    @FindBy(xpath = ".//button[contains(., 'Майские праздники')]")
    private WebElement tourDates;

    @FindBy(xpath = ".//button[contains(., 'Найти туры')]")
    private WebElement buttonSearch;

    @FindBy(xpath = ".//div[@class=\"dayContainer\"]/span[@aria-label=\"Март 22, 2024\"]")
    private WebElement firstDateTour;

    @FindBy(xpath = ".//div[@class=\"dayContainer\"]/span[@aria-label=\"Март 25, 2024\"]")
    private WebElement secondDateTour;

    private final Actions actions;

    public MainPage(WebDriver driver) {
        super(driver);
        actions = new Actions(driver);
    }

    @Step("Проверка Title")
    public MainPage checkTitle() {
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Большая Страна — Все туры по России"));
        return this;
    }

    @Step("Выбор региона для поиска")
    public MainPage selectingRegion(String value) {
        actions
                .click(textBarRegion)
                .sendKeys(value)
                .perform();
        searchResultRegion.click();
        return this;
    }

    @Step("Выбор вида отдыха")
    public MainPage selectingViewRecreation() {
        textBarVieRecreation.click();
        waitElementIsVisible(viewRecreation).click();
        return this;
    }

    @Step("Выбор даты для тура")
    public MainPage selectingDate() {
        textBarDate.click();
        waitElementIsVisible(tourDates).click();
        return this;
    }

    @Step("Нажатие кнопки поиска")
    public MainPage clickButtonOfSearch() {
        waitElementIsVisible(buttonSearch).click();
        return this;
    }

    @Step("Выбор дат на март для тура")
    public MainPage selectingDatesOfMarch() {
        textBarDate.click();
        waitElementIsVisible(firstDateTour);
        Assert.assertTrue(firstDateTour.isDisplayed(), "Element is not displayed");
        firstDateTour.click();
        waitElementIsVisible(secondDateTour);
        Assert.assertTrue(secondDateTour.isDisplayed(), "Element is not displayed");
        secondDateTour.click();
        return this;
    }

}
