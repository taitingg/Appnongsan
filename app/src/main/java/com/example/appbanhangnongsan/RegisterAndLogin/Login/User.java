package com.example.appbanhangnongsan.RegisterAndLogin.Login;

public class User {
    private String email, passWord;

    public User(String email, String passWord) {
        this.email = email;
        this.passWord = passWord;
    }

    public String getUserName() {
        return email;
    }

    public void setUserName(String userName) {
        this.email = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
