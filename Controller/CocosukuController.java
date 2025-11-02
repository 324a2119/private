package com.example.cocosuku.controller;

import com.example.cocosuku.model.User;
import com.example.cocosuku.Service.CocosukuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cocosuku")
@CrossOrigin(origins = "*") // HTMLファイルとの通信を許可
public class CocosukuController {

    @Autowired
    private CocosukuService cocosukuService;

    // 新規登録
    @PostMapping("/register")
    public String register(@RequestBody User user) {
        boolean success = cocosukuService.insertUser(user);
        return success ? "登録成功" : "登録失敗";
    }

    // ログイン
    @PostMapping("/login")
    public User login(@RequestBody User user) {
        return cocosukuService.findUserByEmailAndPassword(user.getEmail(), user.getPassword());
    }

    // ログイン画面の表示
    @GetMapping("/login")
    public String showLoginPage() {
        return "cocologin"; // templates/cocologin.html を返す
    }

    // 新規登録画面の表示
    @GetMapping("/register")
    public String showRegisterPage() {
        return "cocoregister"; // templates/cocoregister.html を返す
    }
}
