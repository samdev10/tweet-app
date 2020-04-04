package com.tweet.test.util;

public enum TweetAppUser {
    PATRON("user", "pass", "firstname", "lastname", "santhoshn.javadeveloper@gmail.com"), INVALID_USER("invalid",
            "invalid", "", "", "");

    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String emailid;

    TweetAppUser(final String user, final String pass, final String firstName, final String lastName,
            final String email) {
        this.username = user;
        this.password = pass;
        this.firstname = firstName;
        this.lastname = lastName;
        this.emailid = email;
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

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }
    
    
}
