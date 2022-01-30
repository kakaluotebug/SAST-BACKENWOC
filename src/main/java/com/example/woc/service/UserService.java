package com.example.woc.service;

import com.example.woc.entity.Account;
import com.example.woc.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: 風楪fy
 * @create: 2022-01-15 01:22
 **/
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public String insert(Account account){
        Account user = userMapper.findUserByName(account.getUsername());
        if (account.getUsername().equals("") || account.getPassword().equals("")){
            return "用户名或密码不能为空";
        }else if (user != null){
            return "用户名已被注册！请重新输入";
        }else {
            userMapper.insertUser(account);
            return "注册成功";
        }
    }

    public Account login(String username,String password){
        return userMapper.userLogin(username,password);
    }

    public Integer select(){
        return userMapper.selectUser();
    }

    public String delete(String username){
        userMapper.deleteUser(username);
        return "删除成功";
    }
}
