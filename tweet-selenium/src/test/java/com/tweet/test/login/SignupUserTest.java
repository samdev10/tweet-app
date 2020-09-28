package com.tweet.test.login;

import static com.tweet.test.util.TweetAppUser.PATRON;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tweet.AbstractTestNGSelenium;

public class SignupUserTest extends AbstractTestNGSelenium {
    @BeforeMethod
    public void setup() {
        userInfoRepository.deleteAll();
    }

    @Test
    public void mustSignupAUser() {
        // When
        tweetApp().signupAs(PATRON);

        // Then
        await().atMost(5, SECONDS)
               .untilAsserted(() -> {
                   assertThat(userInfoRepository.findByUsername(PATRON.getUsername())).isNotNull();
               });
    }
}
