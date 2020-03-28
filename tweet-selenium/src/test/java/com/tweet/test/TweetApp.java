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
    final By error = By.className("error");

    public TweetApp(final WebDriver driver, final String url) {
        this.driver = driver;
        this.url = url;
        driver.get(url);
    }

    public NextPage loginAs(final TweetAppUser user) {
        driver.findElement(username)
              .sendKeys(user.getUsername());
        driver.findElement(password)
              .sendKeys(user.getPassword());
        driver.findElement(By.id("submit"))
              .click();
        return new NextPage();
    }

    public class NextPage
    {
        public HomePage toHomePage() {
            return new HomePage(driver);
        }

        public TweetApp toTweetApp() {
            return TweetApp.this;
        }
    }

    public void close() {
        driver.close();
    }

    public String getErrorMessage() {
        return driver.findElement(error)
                     .getText();
    }

}
