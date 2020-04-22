package com.tweet.security.controller;

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
        userInfoService.saveUserInfo(UserInfo.builder()
                                             .username(data.getUsername())
                                             .emailId(data.getEmailId())
                                             .password(data.getPassword())
                                             .firstname(data.getFirstname())
                                             .lastname(data.getLastname())
                                             .dateOfBirth(data.getDateOfBirth())
                                             .agreeTerms(data.getAgreeTerms())
                                             .build());
        return new RedirectView("/");
    }
}
