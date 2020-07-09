package com.tweet.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage {
    private WebDriver driver;
    private By firstname = By.id("firstname");
    private By lastname = By.id("lastname");
    private By username = By.id("username");
    private By emailId = By.id("emailId");
    private By password = By.id("password");
    private By confirmPassword = By.id("confirmPassword");
    private By dateOfBirth = By.id("dateOfBirth");
    private By agreeTerms = By.id("agreeTerms");
    private By signupButton = By.id("signupButton");

    public SignupPage(final WebDriver driver) {
        this.driver = driver;
    }

    public SignupPage firstname(final String firstname) {
        driver.findElement(this.firstname)
              .sendKeys(firstname);
        return this;
    }

    public SignupPage lastname(final String lastname) {
        driver.findElement(this.lastname)
              .sendKeys(lastname);
        return this;
    }

    public SignupPage username(final String username) {
        driver.findElement(this.username)
              .sendKeys(username);
        return this;
    }

    public SignupPage emailId(final String emailId) {
        driver.findElement(this.emailId)
              .sendKeys(emailId);
        return this;
    }

    public SignupPage password(final String password) {
        driver.findElement(this.password)
              .sendKeys(password);
        return this;
    }

    public SignupPage confirmPassword(final String confirmPassword) {
        driver.findElement(this.confirmPassword)
              .sendKeys(confirmPassword);
        return this;
    }

    public SignupPage dateOfBirth(final String dateOfBirth) {
        driver.findElement(this.dateOfBirth)
              .sendKeys(dateOfBirth);
        return this;
    }

    public SignupPage agreeTerms() {
        driver.findElement(this.agreeTerms)
              .click();
        return this;
    }

    public SignupPage submit() {
        driver.findElement(signupButton)
              .click();
        return this;
    }
}
