package org.example.framework.logger;

import io.qameta.allure.Attachment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.framework.common.CommonDriverActions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class AllureLogger {

    private static final Logger logger = LogManager.getLogger(AllureLogger.class);

    public static void info(String message) {
        logger.info(message);
        attachLogToAllure("[INFO] " + message);
    }

    public static void debug(String message) {
        logger.debug(message);
        attachLogToAllure("[DEBUG] " + message);
    }

    public static void error(String message) {
        logger.error(message);
        attachLogToAllure("[ERROR] " + message);
    }

    @Attachment(value = "Screenshot of {message}", type = "image/png")
    public static byte[] saveScreenshotPNG(String message) {
        return ((TakesScreenshot) CommonDriverActions.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{message}", type = "text/plain")
    public static String attachLogToAllure(String message) {
        return message;
    }
}
