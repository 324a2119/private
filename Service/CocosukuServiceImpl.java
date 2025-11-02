package com.example.cocosuku.Service;

import com.example.cocosuku.Repository.CocosukuDao;
import com.example.cocosuku.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CocosukuServiceImpl implements CocosukuService {

    @Autowired
    private CocosukuDao userDao;

    @Override
    public boolean insertUser(User user) {
        // パスワードはハッシュ化せずに保存
        return userDao.insertUser(user) > 0;
    }

    @Override
    public User findUserByEmailAndPassword(String email, String password) {
        return userDao.findUserByEmailAndPassword(email, password);
    }
}
