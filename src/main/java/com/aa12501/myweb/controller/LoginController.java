package com.aa12501.myweb.controller;

import com.aa12501.myweb.entities.UserEntity;
import com.aa12501.myweb.inter.ILogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @Autowired
    private ILogin loginServer;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam(name = "userId", required = false) Integer userId,
                          @RequestParam(name = "password", required = false) String password,
                          Model model,
                          HttpServletResponse response,
                          HttpServletRequest request) {
        if (userId == null) {
            String error = "账号未填写";
            model.addAttribute("error", error);
            return "login";
        }

        if (password == null) {
            String error = "密码未填写";
            model.addAttribute("error", error);
            return "login";
        }


        return null;
    }

    @GetMapping("/registry")
    public String registry() {
        return "registry";
    }

//    @PostMapping("/registry")
//    @ResponseBody
//    public String doRegistry(@RequestParam(value = "userId", required = false) Integer userId,
//                             @RequestParam(value = "email", required = false) String email,
//                             @RequestParam(value = "userName", required = false) String userName,
//                             @RequestParam(value = "userPassword", required = false) String userPassword,
//                             @RequestParam(value = "userPasswordConfirm", required = false) String userPasswordConfirm) {
//        try {
//            loginServer.saveUser(userId, email, userName, userPassword, userPasswordConfirm);
//        } catch (Exception e) {
//            return e.getMessage();
//        }
//
//        return "ok";
//
//    }
    @PostMapping("/registry")
    @ResponseBody
    public String doRegistry(@RequestBody UserEntity userEntity){
        try {
            loginServer.saveUser(userEntity);
        } catch (Exception e) {
            return e.getMessage();
        }

        return "ok";

    }
}
