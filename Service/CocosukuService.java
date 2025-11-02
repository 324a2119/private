package com.example.cocosuku.Service;

import com.example.cocosuku.model.User;

public interface CocosukuService {
    boolean insertUser(User user);
    User findUserByEmailAndPassword(String email, String password);
}
