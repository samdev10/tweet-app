package com.tweet.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By heading = By.tagName("h1");

    public HomePage(final WebDriver driver) {
        this.driver = driver;
    }

    public String getHeading() {
        return driver.findElement(heading)
                     .getText();
    }
}
