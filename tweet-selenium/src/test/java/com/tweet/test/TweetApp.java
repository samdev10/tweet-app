package com.tweet.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tweet.test.pages.HomePage;
import com.tweet.test.pages.SignupPage;
import com.tweet.test.util.TweetAppUser;

public class TweetApp {
    private WebDriver driver;
    private String url;
    final By username = By.id("username");
    final By password = By.id("password");
    final By error = By.className("error");
    private By signUpLink = By.id("signupLink");

    public TweetApp(final WebDriver driver, final String url) {
        this.driver = driver;
        this.url = url;
        driver.get(url);
    }

    public NextPage signupAs(final TweetAppUser user) {
        driver.findElement(signUpLink)
              .click();
        final SignupPage signupPage = new SignupPage(driver);
        signupPage.firstname(user.getFirstname())
                  .lastname(user.getLastname())
                  .username(user.getUsername())
                  .emailId(user.getEmailid())
                  .dateOfBirth(user.getDateOfBirth())
                  .password(user.getPassword())
                  .confirmPassword(user.getPassword())
                  .agreeTerms()
                  .submit();
        return new NextPage();
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
        public SignupPage toSignup() {
            return new SignupPage(driver);
        }

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
