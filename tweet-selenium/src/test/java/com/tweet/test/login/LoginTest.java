package com.tweet.test.login;

import static com.tweet.test.util.TweetAppUser.INVALID_USER;
import static com.tweet.test.util.TweetAppUser.PATRON;
import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

import com.tweet.AbstractTestNGSelenium;
import com.tweet.test.TweetApp;
import com.tweet.test.pages.HomePage;

public class LoginTest extends AbstractTestNGSelenium {
    @Test
    public void mustLoginIntoTweetApp() {
        // Given
        createUserInfo(PATRON);

        // When
        final HomePage homePage = tweetApp().loginAs(PATRON)
                                            .toHomePage();

        // Then 
        assertThat(homePage.getHeading()).isEqualTo("Tweet");
    }

    @Test
    public void mustNotLoginIntoTweetApp() {
        // When
        final TweetApp app = tweetApp().loginAs(INVALID_USER)
                                            .toTweetApp();

        // Then 
        assertThat(app.getErrorMessage()).isEqualTo("Username and password are invalid");
    }
}
