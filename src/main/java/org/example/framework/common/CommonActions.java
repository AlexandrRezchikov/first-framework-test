package org.example.framework.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.time.Duration;

import static org.example.framework.config.Config.IMPLICIT_WAIT;
import static org.example.framework.config.Config.PLATFORM_AND_BROWSER;

public class CommonActions {

    private static WebDriver driver;

    private static Actions actions;

    private static void createDriver() {

        switch (PLATFORM_AND_BROWSER) {
            case "win_chrome":
                driver = new ChromeDriver();
                break;
            case "win_firefox":
                driver = new FirefoxDriver();
                break;
            default:
                Assert.fail("Incorrect platform or browser name: " + PLATFORM_AND_BROWSER);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
        actions = new Actions(driver);
    }

    public static void setDriver() {
        if (driver == null)
            createDriver();
    }

    public static WebDriver getDriver() {
        setDriver();
        return driver;
    }

    public static Actions getActions() {
        return actions;
    }

}
