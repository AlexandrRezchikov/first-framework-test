package org.example.common;

import java.util.ResourceBundle;

public class Config {

    private static final ResourceBundle config = ResourceBundle.getBundle("config");

    // ОС и браузер
    public static final String PLATFORM_AND_BROWSER = config.getString("platform_and_browser");

    // Очистка cookies
    // if true - очистить cookies
    public static final Boolean CLEAR_COOKIES_AND_STORAGE = config.containsKey("clear_cookies_and_storage");

    // Закрытие браузера
    // if true - браузер закрывается
    public static final Boolean HOLD_BROWSER_OPEN = config.containsKey("hold_browser_open");

}
