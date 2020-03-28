package com.tweet.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tweet.test.pages.HomePage;
import com.tweet.test.util.TweetAppUser;

public class TweetApp {
    private WebDriver driver;
    private String url;
    final By username = By.id("username");
    final By password = By.id("password");

    public TweetApp(final WebDriver driver, final String url) {
        this.driver = driver;
        this.url = url;
        driver.get(url);
    }

    public HomePage loginAs(final TweetAppUser user) {
        driver.findElement(username)
              .sendKeys(user.getUsername());
        driver.findElement(password)
              .sendKeys(user.getPassword());
        return new HomePage(driver);
    }

    public void close() {
        driver.close();
    }

}
