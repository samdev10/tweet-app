package com.tweet;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import com.tweet.data.config.MongoConfig;
import com.tweet.repository.UserInfoRepository;

@ContextConfiguration(classes = { MongoConfig.class })
@EnableMongoRepositories(basePackages = "com.tweet.repository")
public class AbstractTestNGSelenium extends AbstractTestNGSpringContextTests {
    private WebDriver driver;

    @Autowired
    private UserInfoRepository userInfoRepository;

    @BeforeMethod
    public void testSetup() throws IOException {
        driver = new ChromeDriver();
        String baseUrl = "http://localhost:8080";
        driver.get(baseUrl);
    }

    @AfterTest
    public void close() {
        driver.close();
    }
}
