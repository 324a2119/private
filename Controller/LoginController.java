package com.example.cocosuku.Controller;

import com.example.cocosuku.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(
            @RequestParam String email,
            @RequestParam String password,
            HttpSession session) {

        boolean success = userService.login(email, password);
        if (success) {
            session.setAttribute("email", email);
            return "OK";
        } else {
            return "NG";
        }
    }
}
