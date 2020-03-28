package com.tweet.test.util;

public enum TweetAppUser {
    PATRON("user", "pass");

    private String username;
    private String password;

    TweetAppUser(final String user, final String pass) {
        this.username = user;
        this.password = pass;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }
    
    
}
