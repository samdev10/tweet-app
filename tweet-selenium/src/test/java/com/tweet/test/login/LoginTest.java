package com.tweet.test.login;

import static com.tweet.bo.UserInfo.SEQUENCE_NAME;
import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

import com.tweet.AbstractTestNGSelenium;
import com.tweet.bo.UserInfo;
import com.tweet.test.pages.HomePage;

public class LoginTest extends AbstractTestNGSelenium {
    @Test
    public void mustLoginIntoTweetApp() {
        // Given
        final Long sequenceNumber = sequenceGenerator().generateSequence(SEQUENCE_NAME);
        final UserInfo userInfo = UserInfo.builder()
                                          .id(sequenceNumber)
                                          .userName("sam1")
                                          .password("password")
                                          .build();
        userInfoRepository.save(userInfo);

        // When
        final HomePage homePage = tweetApp().toLoginPage()
                  .loginAs("sam1", "password");

        // Then
        assertThat(homePage.getHeading()).isEqualTo("Arupu");
    }
}
