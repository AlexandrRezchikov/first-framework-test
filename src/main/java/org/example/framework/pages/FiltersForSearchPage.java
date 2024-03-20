package org.example.framework.pages;

import io.qameta.allure.Step;
import org.example.framework.common.CommonDriverActions;
import org.example.framework.logger.AllureLogger;
import org.example.framework.utils.Regex;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.Set;

public class FiltersForSearchPage extends BasePage {

    private final By cardOfTour = By.xpath("//section[@id=\"group-initial\"]//div[@class=\"as-col tour-previews__col\"]"); // карточка тура
//    @FindBy(xpath = "//section[@id=\"group-initial\"]//div[@class=\"as-col tour-previews__col\"]")
//    private WebElement cardOfTour;

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

    @Step("Проверка количества найденных туров")
    public FiltersForSearchPage checkingCountTours() {
        AllureLogger.debug("Checking count tour");
        waitElementIsVisible(buttonNumberOfTours);
        buttonNumberOfTours.click();
        Assert.assertTrue(buttonNumberOfTours.isDisplayed(), "Button number of tours is not displayed");
        String numberOfTours = buttonNumberOfTours.getText();
        System.out.println(numberOfTours);
        int numberOfCard = CommonDriverActions.getDriver().findElements(cardOfTour).size();
        System.out.println("Карточек туров на странице " + numberOfCard);
        Assert.assertEquals(numberOfCard, Regex.regexForNumberOfTours(numberOfTours));
        return this;
    }

    @Step("Выбор дополнительных фильтров")
    public FiltersForSearchPage selectFilters() {
        AllureLogger.debug("Select filters");
        Assert.assertTrue(filterApartments.isDisplayed(), "Element is not displayed");
        filterApartments.click();
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
        AllureLogger.debug("Changing price of tour");
        CommonDriverActions.getActions().moveToElement(sliderMaxPrice).dragAndDropBy(sliderMaxPrice, -180, 0).perform();
        Assert.assertTrue(filterApartments.isDisplayed(), "Element is not displayed");
        return this;
    }

    @Step("Просмотр информации о туре")
    public FiltersForSearchPage watchInfoOfTour() {
        AllureLogger.debug("Watching info of tour");
        Assert.assertTrue(buttonWatchTheTour.isDisplayed(), "Element is not displayed");
        buttonWatchTheTour.click();
        return this;
    }

    @Step("Переключение на новый фрейм")
    public FiltersForSearchPage switchingFrame() {
        AllureLogger.debug("Switching frame");
        String currentWindowHandle = CommonDriverActions.getDriver().getWindowHandle();
        Set<String> windowHandles = CommonDriverActions.getDriver().getWindowHandles();
        String nextWindowHandle = "";
        for (String handle : windowHandles) {
            if (!handle.equals(currentWindowHandle)) {
                nextWindowHandle = handle;
                break;
            }
        }
        CommonDriverActions.getDriver().switchTo().window(nextWindowHandle);
        return this;
    }

}
