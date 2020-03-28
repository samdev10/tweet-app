package com.tweet.test;

import org.openqa.selenium.WebDriver;

import com.tweet.test.pages.LoginPage;

public class TweetApp {
    private WebDriver driver;
    private String url;

    public TweetApp(final WebDriver driver, final String url) {
        this.driver = driver;
        this.url = url;
    }

    public LoginPage toLoginPage() {
        driver.get(url);
        return new LoginPage(driver);
    }

    public void close() {
        driver.close();
    }

}
