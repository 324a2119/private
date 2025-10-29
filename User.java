package com.example.cocosuku.model;

public class User {
    private int userid;
    private String email;
    private String password;
    private String name;
    private String profile_image; 

    // --- getter & setter ---
    public int getUserid() { return userid; }
    public void setUserid(int userid) { this.userid = userid; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    // 追加
    public String getProfile_image() { return profile_image; }
    public void setProfile_image(String profile_image) { this.profile_image = profile_image; }
}
