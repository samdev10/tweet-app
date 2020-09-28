package com.tweet.security.bo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Signup Request.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest implements Serializable {
    private static final long serialVersionUID = -5661633722744629741L;
    private String firstname;
    private String lastname;
    private String username;
    private String dateOfBirth;
    private String emailId;
    private String password;
    private Boolean agreeTerms;
}
