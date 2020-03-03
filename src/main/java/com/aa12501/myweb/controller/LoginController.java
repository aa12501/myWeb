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
    @ResponseBody
    public String doLogin(@RequestBody UserEntity userEntity,
                          HttpServletRequest request,
                          HttpServletResponse response) {
        String ret = "ok";
        UserEntity userCheck = loginServer.findById(userEntity.getUserId());
        if (userCheck == null){
            ret = "账号不存在或密码错误";
        }
        else if (!userCheck.getPassword().equals(userEntity.getPassword())){
            ret = "账号不存在或密码错误";
        }else {
            userCheck.setPassword("");
            request.getSession().setAttribute("user", userCheck);
        }

        return ret;
    }

    @GetMapping("/registry")
    public String registry() {
        return "registry";
    }

    @PostMapping("/registry")
    @ResponseBody
    public String doRegistry(@RequestBody UserEntity userEntity){
        String ret = "ok";
        try {
            loginServer.saveUser(userEntity);
        } catch (Exception e) {
            ret = e.getMessage();
        }

        return ret;
    }
}
