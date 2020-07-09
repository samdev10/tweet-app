package com.tweet.security.controller;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.tweet.bo.UserInfo;
import com.tweet.graphql.UserInfoService;
import com.tweet.security.bo.SignupRequest;

/**
 * SignUp Controller.
 */
@RestController
public class SignUpController {
    @Autowired
    private UserInfoService userInfoService;

    /**
     * @param data the signup request
     * @return redirect view.
     */
    @PostMapping("/save_user")
    public RedirectView signup(@RequestBody final SignupRequest data) {
        LocalDateTime date = LocalDateTime.parse(
                 Instant.parse(data.getDateOfBirth() + "T00:00:00.000Z")
                        .truncatedTo(ChronoUnit.DAYS)
                        .toString(),
                 DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"));
        System.out.println(date);
        userInfoService.saveUserInfo(UserInfo.builder()
                                             .username(data.getUsername())
                                             .emailId(data.getEmailId())
                                             .password(data.getPassword())
                                             .firstname(data.getFirstname())
                                             .lastname(data.getLastname())
                                             .dateOfBirth(date)
                                             .agreeTerms(data.getAgreeTerms())
                                             .build());
        return new RedirectView("/");
    }
}
