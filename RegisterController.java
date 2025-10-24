package com.example.cocosuku.controller;

import com.example.cocosuku.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password,
            HttpSession session) {

        int createdId = userService.register(name, email, password);
        if (createdId > 0) {
            // 作成成功 -> セッションに入れる
            session.setAttribute("email", email);
            session.setAttribute("userid", createdId);
            return "OK";
        } else {
            return "NG";
        }
    }
}
