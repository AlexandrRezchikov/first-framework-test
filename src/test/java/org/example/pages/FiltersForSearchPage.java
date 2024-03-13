package org.example.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.Set;

import static org.example.regexs.regexForNumberOfTours.regexForNumberOfTours;

public class FiltersForSearchPage extends BasePage {

    private final By cardOfTour = By.xpath("//section[@id=\"group-initial\"]//div[@class=\"as-col tour-previews__col\"]"); // карточка тура

    @FindBy(xpath = ".//button[contains(.,'Найден')]") // кнопка с количеством найденных туров
    private WebElement buttonNumberOfTours;

    @FindBy(xpath = "//div[text()=\"Проживание\"]")
    private WebElement filterApartments;

    @FindBy(xpath = ".//span[contains(., 'Гостиница')]")
    private WebElement subFilterApartments;

    @FindBy(xpath = "//div[text()=\" Комфорт проживания \"]")
    private WebElement filterComfortOfTheApartments;

    @FindBy(xpath = "//div[@class=\"collapse__body\"]//span[contains(., 'Высокий')]")
    private WebElement subFilterComfortOfTheApartments;

    @FindBy(css = "#filter-difficulty use")
    private WebElement filterLevelDifficulty;

    @FindBy(xpath = "//*[@id=\"search-filter-difficulty\"]/label[1]/div/span[@class=\"as-checkbox__icon\"]")
    private WebElement subFilterLevelDifficulty;

    @FindBy(xpath = "//div[@aria-valuenow=\"200000\"]")
    private WebElement sliderMaxPrice;

    @FindBy(xpath = "//div[@class=\"tour-preview\"]//span[contains(.,'Смотреть тур')]")
    private WebElement buttonWatchTheTour;

    private final Actions actions;

    public FiltersForSearchPage(WebDriver driver) {
        super(driver);
        actions = new Actions(driver);
    }

    @Step("Проверка количества найденных туров")
    public FiltersForSearchPage checkingCountTours() {
        waitElementIsVisible(buttonNumberOfTours);
        Assert.assertTrue(buttonNumberOfTours.isDisplayed(), "Button number of tours is not displayed");
        String numberOfTours = buttonNumberOfTours.getText();
        System.out.println(numberOfTours);
        int numberOfCard = driver.findElements(cardOfTour).size();
        System.out.println("Карточек туров на странице " + numberOfCard);
        Assert.assertEquals(numberOfCard, regexForNumberOfTours(numberOfTours));
        return this;
    }

    @Step("Выбор дополнительных фильтров")
    public FiltersForSearchPage selectFilters() {
        Assert.assertTrue(filterApartments.isDisplayed(), "Element is not displayed");
        actions
                .moveToElement(filterApartments)
                .click()
                .perform();
        Assert.assertTrue(subFilterApartments.isDisplayed(), "Element is not displayed");
        subFilterApartments.click();
        Assert.assertTrue(filterComfortOfTheApartments.isDisplayed(), "Element is not displayed");
        filterComfortOfTheApartments.click();
        Assert.assertTrue(subFilterComfortOfTheApartments.isDisplayed(), "Element is not displayed");
        subFilterComfortOfTheApartments.click();
        Assert.assertTrue(filterLevelDifficulty.isDisplayed(), "Element is not displayed");
        filterLevelDifficulty.click();
        Assert.assertTrue(subFilterLevelDifficulty.isDisplayed(), "Element is not displayed");
        subFilterLevelDifficulty.click();
        waitElementIsVisible(buttonNumberOfTours);
        return this;
    }

    @Step("Изменение фильтра стоимости туров")
    public FiltersForSearchPage moveSliderPrice() {
        actions.moveToElement(sliderMaxPrice).dragAndDropBy(sliderMaxPrice, -180, 0).perform();
        return this;
    }

    @Step("Просмотр информации о туре")
    public FiltersForSearchPage watchInfoOfTour() {
        Assert.assertTrue(buttonWatchTheTour.isDisplayed(), "Element is not displayed");
        buttonWatchTheTour.click();
        return this;
    }

    @Step("Переключение на новый фрейм")
    public FiltersForSearchPage switchingFrame() {
        String currentWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        String nextWindowHandle = "";
        for (String handle : windowHandles) {
            if (!handle.equals(currentWindowHandle)) {
                nextWindowHandle = handle;
                break;
            }
        }
        driver.switchTo().window(nextWindowHandle);
        return this;
    }

}
