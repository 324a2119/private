package com.example.cocosuku;

import com.example.cocosuku.dao.UserDao;
import com.example.cocosuku.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    /**
     * ログイン検証
     * @return true=認証成功
     */
    public boolean login(String email, String password) {
        User user = userDao.findByEmail(email);
        if (user == null) return false;
        String hashed = user.getPassword();
        return BCrypt.checkpw(password, hashed);
    }

    /**
     * 新規登録
     * @return created user's id (>0) if success, -1 on failure (e.g. duplicate email)
     */
    public int register(String name, String email, String rawPassword) {
        // 既に存在するか
        if (userDao.findByEmail(email) != null) {
            return -1; // 既に存在
        }

        // BCrypt ハッシュ（work factor はデフォルト 10）
        String hashed = BCrypt.hashpw(rawPassword, BCrypt.gensalt());

        User u = new User();
        u.setName(name);
        u.setEmail(email);
        u.setPassword(hashed);
        u.setProfile_image(null); // 初期値

        return userDao.createUser(u);
    }
}
