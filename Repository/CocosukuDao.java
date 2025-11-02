package com.example.cocosuku.Repository;

import com.example.cocosuku.model.User;

public interface CocosukuDao {
    int insertUser(User user);
    User findUserByEmailAndPassword(String email, String password);
}
