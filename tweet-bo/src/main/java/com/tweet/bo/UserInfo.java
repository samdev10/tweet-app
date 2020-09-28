package com.tweet.bo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User Info.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "users")
public class UserInfo {
    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";
    @MongoId
    private Long id;
    private String firstname;
    private String lastname;
    @Indexed(unique = true)
    private String username;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dateOfBirth;
    private String emailId;
    private String password;
    private Boolean agreeTerms;
    private List<String> roles;
}
