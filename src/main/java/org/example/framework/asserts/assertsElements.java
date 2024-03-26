package org.example.framework.asserts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class assertsElements {

    public static void isElementDisplayed(WebElement element) {
        Assert.assertTrue(element.isDisplayed(), element + "Element is not displayed");
    }

    public static void isElementDisplayedAndClick(WebElement element) {
        Assert.assertTrue(element.isDisplayed(), element + "Element is not displayed");
        element.click();
    }

    public static void equalsInteger(int integer, int i){
        Assert.assertEquals(integer, i, " количество не равно!");
    }
}
