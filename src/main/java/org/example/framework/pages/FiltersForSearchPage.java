package org.example.framework.pages;

import io.qameta.allure.Step;
import org.example.framework.asserts.assertsElements;
import org.example.framework.common.DriverActions;
import org.example.framework.logger.AllureLogger;
import org.example.framework.utils.Regex;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class FiltersForSearchPage extends BasePage {

    @FindBy(xpath = "//section[@id=\"group-initial\"]//div[@class=\"as-col tour-previews__col\"]") // карточка тура
    private List<WebElement> cardOfTour;

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

    @FindBy(xpath = "//div[@class='as-input-range__inputs']//input[@name='max']")
    private WebElement inputBoxMaxPrice;

    @Step("Проверка количества найденных туров")
    public FiltersForSearchPage checkingCountTours() {
        AllureLogger.debug("Checking count tour");
        waitElementToBeClickable(buttonNumberOfTours);
        waitTextToBePresentInElement(buttonNumberOfTours);
        assertsElements.isElementDisplayed(buttonNumberOfTours);
        String numberOfTours = buttonNumberOfTours.getText();
        System.out.println(numberOfTours);
        int numberOfCard = cardOfTour.size();
        System.out.println("Карточек туров на странице " + numberOfCard);
        assertsElements.equalsInteger(numberOfCard, Regex.regexForNumberOfTours(numberOfTours));
        return this;
    }

    @Step("Выбор дополнительных фильтров")
    public FiltersForSearchPage selectFilters() {
        AllureLogger.debug("Select filters");
        filterApartments.click();
        subFilterApartments.click();
        filterComfortOfTheApartments.click();
        subFilterComfortOfTheApartments.click();
        filterLevelDifficulty.click();
        subFilterLevelDifficulty.click();
        waitElementIsVisible(buttonNumberOfTours);
        return this;
    }

    @Step("Изменение фильтра стоимости туров")
    public FiltersForSearchPage moveSliderPrice() {
        AllureLogger.debug("Changing price of tour");
        DriverActions.getActions().moveToElement(sliderMaxPrice).dragAndDropBy(sliderMaxPrice, -180, 0).perform();
        assertsElements.isElementDisplayed(buttonNumberOfTours);
        DriverActions.getActions().moveToElement(buttonNumberOfTours).click().perform();
        return this;
    }

    @Step("Просмотр информации о туре")
    public FiltersForSearchPage watchInfoOfTour() {
        AllureLogger.debug("Watching info of tour");
        buttonWatchTheTour.click();
        return this;
    }

    @Step("Переключение на новый фрейм")
    public FiltersForSearchPage switchingFrame() {
        AllureLogger.debug("Switching frame");
        DriverActions.switchToFrame();
        return this;
    }

}
