package com.tweet.test.login;

import static com.tweet.test.util.TweetAppUser.PATRON;
import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

import com.tweet.AbstractTestNGSelenium;
import com.tweet.test.pages.HomePage;

public class LoginTest extends AbstractTestNGSelenium {
    @Test
    public void mustLoginIntoTweetApp() {
        // Given
        createUserInfo(PATRON);

        // When
        final HomePage homePage = tweetApp().loginAs(PATRON);

        // Then 
        assertThat(homePage.getHeading()).isEqualTo("Tweet");
    }
}
