package org.example.common;

public class Config {

    // ОС и браузер
    public static final String PLATFORM_AND_BROWSER = ConfigReader.platformAndBrowser();

    // Очистка cookies
    // if true - очистить cookies
    public static final Boolean CLEAR_COOKIES_AND_STORAGE = ConfigReader.clearCookiesAndStorage();

    // Закрытие браузера
    // if true - браузер закрывается
    public static final Boolean HOLD_BROWSER_OPEN = ConfigReader.holdBrowserOpen();



}
