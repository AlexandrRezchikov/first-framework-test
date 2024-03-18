package org.example.framework.pages;

import io.qameta.allure.Step;
import org.example.framework.utils.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;;
import org.testng.Assert;

import java.util.ResourceBundle;

public class ApplicationForTourPage extends BasePage {

    private static final ResourceBundle resource = ResourceBundle.getBundle("text");

    @FindBy(css = ".as-input__append")
    private WebElement barOfSelectingTourDate;

    @FindBy(xpath = "//li[@class='as-select__list-item']//strong[text()='3—5 мая']")
    private WebElement dateOfTour;

    @FindBy(xpath = "//input[@name='name']")
    private WebElement textBarName;

    @FindBy(xpath = "//input[@name='phone']")
    private WebElement textBarPhoneNumber;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement textBarEmail;

    @FindBy(xpath = "//button[@name='submit']")
    private WebElement buttonSendRequest;

    @FindBy(xpath = "//span[contains(., 'Введите корректный номер телефона')]")
    private WebElement errorMessageValidatingPhoneNumber;

    @FindBy(xpath = ".//span[contains(., 'Вернуться')]")
    private WebElement buttonGoToBack;

    public ApplicationForTourPage(WebDriver driver) {
        super(driver);
    }

    @Step("Проверка Title страницы бронирования тура")
    public ApplicationForTourPage checkTitle() {
        AllureLogger.debug("Checking title page");
        waitElementIsVisible(buttonGoToBack);
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Заявка на тур | Большая Страна"));
        return this;
    }

    @Step("Выбор дат в форме брони")
    public ApplicationForTourPage selectingDate() {
        AllureLogger.debug("Selecting date");
        Assert.assertTrue(barOfSelectingTourDate.isDisplayed(), "Element is not displayed");
        barOfSelectingTourDate.click();
        dateOfTour.click();
        return this;
    }

    @Step("Заполнение поля ФИО в форме брони")
    public ApplicationForTourPage enteringName() {
        AllureLogger.debug("Input Name: " + resource.getString("name"));
        Assert.assertTrue(textBarName.isDisplayed(), "Element is not displayed");
        textBarName.click();
        textBarName.sendKeys(resource.getString("name"));
        return this;
    }

    @Step("Заполнение поля номера телефона в форме брони")
    public ApplicationForTourPage enteringPhoneNumber() {
        AllureLogger.debug("Input phone number: " + resource.getString("phoneNumber"));
        Assert.assertTrue(textBarPhoneNumber.isDisplayed(), "Element is not displayed");
        textBarPhoneNumber.click();
        textBarPhoneNumber.sendKeys(resource.getString("phoneNumber"));
        return this;
    }

    @Step("Заполнение поля email в форме брони")
    public ApplicationForTourPage enteringEmail() {
        AllureLogger.debug("Input email: " + resource.getString("mail"));
        Assert.assertTrue(textBarEmail.isDisplayed(), "Element is not displayed");
        textBarEmail.click();
        textBarEmail.sendKeys(resource.getString("mail"));
        return this;
    }

    @Step("Отправка заполненной формы брони")
    public ApplicationForTourPage sendApplication() {
        AllureLogger.debug("Clicking to button send");
        Assert.assertTrue(buttonSendRequest.isDisplayed(), "Button is not displayed");
        buttonSendRequest.click();
        return this;
    }

    @Step("Проверка ошибки")
    public ApplicationForTourPage checkingErrorMessage() {
        AllureLogger.info("Checking message");
        Assert.assertTrue(errorMessageValidatingPhoneNumber.isDisplayed());
        System.out.println("Текст ошибки: " + errorMessageValidatingPhoneNumber.getText());
        return this;
    }
}
