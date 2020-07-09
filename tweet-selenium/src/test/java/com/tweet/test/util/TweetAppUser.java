package com.tweet.test.util;

public enum TweetAppUser {
    PATRON("user", "pass", "firstname", "lastname", "santhoshn.javadeveloper@gmail.com",
            "10/01/1990"), INVALID_USER("invalid",
                    "invalid", "", "", "", "");

    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String emailid;
    private String dateOfBirth;

    TweetAppUser(final String user, final String pass, final String firstName, final String lastName,
            final String email, final String dateOfBirth) {
        this.username = user;
        this.password = pass;
        this.firstname = firstName;
        this.lastname = lastName;
        this.emailid = email;
        this.dateOfBirth = dateOfBirth;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(final String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(final String lastname) {
        this.lastname = lastname;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(final String emailid) {
        this.emailid = emailid;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(final String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
