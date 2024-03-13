package org.example.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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

    @Step
    public ApplicationForTourPage checkTitle() {
        waitElementIsVisible(buttonGoToBack);
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Заявка на тур | Большая Страна"));
        return this;
    }

    @Step
    public ApplicationForTourPage selectingDate() {
        Assert.assertTrue(barOfSelectingTourDate.isDisplayed(), "Element is not displayed");
        barOfSelectingTourDate.click();
        dateOfTour.click();
        return this;
    }

    @Step
    public ApplicationForTourPage enteringName() {
        Assert.assertTrue(textBarName.isDisplayed(), "Element is not displayed");
        textBarName.click();
        textBarName.sendKeys(resource.getString("name"));
        return this;
    }

    @Step
    public ApplicationForTourPage enteringPhoneNumber() {
        Assert.assertTrue(textBarPhoneNumber.isDisplayed(), "Element is not displayed");
        textBarPhoneNumber.click();
        textBarPhoneNumber.sendKeys(resource.getString("phoneNumber"));
        return this;
    }

    @Step
    public ApplicationForTourPage enteringEmail() {
        Assert.assertTrue(textBarEmail.isDisplayed(), "Element is not displayed");
        textBarEmail.click();
        textBarEmail.sendKeys(resource.getString("mail"));
        return this;
    }

    @Step
    public ApplicationForTourPage sendApplication() {
        Assert.assertTrue(buttonSendRequest.isDisplayed(), "Button is not displayed");
        buttonSendRequest.click();
        return this;
    }

    @Step
    public ApplicationForTourPage checkingErrorMessage() {
        Assert.assertTrue(errorMessageValidatingPhoneNumber.isDisplayed());
        System.out.println("Текст ошибки: " + errorMessageValidatingPhoneNumber.getText());
        return this;
    }
}
