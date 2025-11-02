package com.example.cocosuku.model;

public class User {
    private int userid;
    private String name;
    private String email;
    private String password;
    private String profileImage;

    public User() {}

    public User(int userid, String name, String email, String password, String profileImage) {
        this.userid = userid;
        this.name = name;
        this.email = email;
        this.password = password;
        this.profileImage = profileImage;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }
}
