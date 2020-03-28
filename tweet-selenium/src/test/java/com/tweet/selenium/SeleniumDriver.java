package com.tweet.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumDriver {
    private SeleniumDriver() {
    };

    private static WebDriver createDriver() {
        final ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        final WebDriver driver = new ChromeDriver(options);
        return driver;
    }

    private static class seleniumDriver {
        private static final WebDriver INSTANCE = createDriver();
    }

    public static WebDriver getInstance() {
        return seleniumDriver.INSTANCE;
    }
}
