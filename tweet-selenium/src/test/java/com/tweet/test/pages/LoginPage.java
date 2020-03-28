package com.tweet.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    final By password = By.name("password");
    final By username = By.name("username");

    public LoginPage(final WebDriver driver) {
        this.driver = driver;
    }
    
    public HomePage loginAs(final String user, final String pass) {
        driver.findElement(username)
              .sendKeys(user);
        driver.findElement(password)
              .sendKeys(pass);
        return new HomePage(driver);
    }
}
