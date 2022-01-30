package com.example.woc.controller;

import com.example.woc.entity.Account;
import com.example.woc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: 風楪fy
 * @create: 2022-01-15 01:22
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 完成注册功能
     * 选做：对密码进行加密处理
     * @param account
     * @return
     */
    @PostMapping("/register")
    public String uploadUsername(Account account) {

        return userService.insert(account);

    }

    /**
     * 完成登录功能
     * @param account
     * @return 是否登录成功
     */
    @PostMapping("/login")
    public Boolean login(Account account) {

        Account user = userService.login(account.getUsername(), account.getPassword());
        if (user == null){
            return false;
        }else {
            return true;
        }
    }
}


