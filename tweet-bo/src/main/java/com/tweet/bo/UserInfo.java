package com.tweet.bo;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

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
    private String firstName;
    private String lastName;
    private String userName;
    private Date dateOfBirth;
    private String emailId;
    private String password;
    private List<String> roles;
}
