package edu.kau.fcit.cpit252.transactions;

import java.util.Date;

public class User {
    private String username;
    private String email;
    private String password;
    private Date lastSignIn;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.lastSignIn = new Date();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastSignIn() {
        return lastSignIn;
    }

    public void setLastSignIn(Date lastSignIn) {
        this.lastSignIn = lastSignIn;
    }
}
