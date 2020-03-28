package com.tweet.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tweet.test.util.TweetAppUser;

public class LoginPage {
    private WebDriver driver;
    final By username = By.id("username");
    final By password = By.id("password");

    public LoginPage(final WebDriver driver) {
        this.driver = driver;
    }
    
    public HomePage loginAs(final TweetAppUser user) {
        driver.findElement(username)
              .sendKeys(user.getUsername());
        driver.findElement(password)
              .sendKeys(user.getPassword());
        return new HomePage(driver);
    }
}
