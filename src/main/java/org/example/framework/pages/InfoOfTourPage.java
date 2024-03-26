package org.example.framework.pages;

import io.qameta.allure.Step;
import org.example.framework.bo.TourInfo;
import org.example.framework.logger.AllureLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class InfoOfTourPage extends BasePage {

    public static final String PRICE = "26 900 ₽";

    public static final String DESCRIPTION = "Увлекательное путешествие на квадроциклах по лесу. " +
            "Вы восхититесь разнообразием рельефа, преодолевая ручьи, " +
            "заболоченные места, поля, лесные дороги. Серьезная борьба с бездорожьем не помешает " +
            "полюбоваться на дивный лес и маленькие лесные озера — ламбушки.";

    public static final String TOUR_NAME = "Шуйский мультиактив. Квадроциклы и рафтинг";

    @FindBy(xpath = "//div[@class='tour-sidebar']//button[contains(., 'Забронировать места')]")
    private WebElement buttonReserve;

    @FindBy(xpath = "//aside[@class='tour-content__aside']//strong[@class='sidebar-resume__price-value']")
    private WebElement price;

    @FindBy(xpath = "//section[@id='browse']//p")
    private WebElement description;

    @FindBy(xpath = "//div[@class='tour-header__content']/h1[@class='tour-header__title']")
    private WebElement tourName;

    @Step("Переход на страницу бронирования тура")
    public InfoOfTourPage switchingToPageBookYourPlace() {
        AllureLogger.debug("Go to page book your place");
        Assert.assertTrue(buttonReserve.isDisplayed(), "Button number of tours is not displayed");
        buttonReserve.click();
        return this;
    }

    @Step("Првоерка информации о туре на странице тура")
    public InfoOfTourPage validateInfoOfTour(TourInfo tour) {
        AllureLogger.debug("Проверка информации на странице тура");
        Assert.assertEquals(price.getText().trim(), tour.getPrice(), "Tour price is not correct!");
        Assert.assertEquals(description.getText().trim(), tour.getDescription(), "Tour description is not correct!");
        Assert.assertEquals(tourName.getText().trim(), tour.getTourName(), "Tour name is not correct!");
        return this;
    }
}
