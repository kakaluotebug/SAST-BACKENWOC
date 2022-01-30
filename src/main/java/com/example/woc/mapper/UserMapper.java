package com.example.woc.mapper;

import com.example.woc.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: 風楪fy
 * @create: 2022-01-15 01:22
 **/
@Mapper
@Repository
public interface UserMapper {

    void insertUser(Account user);
    Account findUserByName(@Param("username") String username);
    Account userLogin(@Param("username") String username,@Param("password") String password);
    void deleteUser(@Param("username") String username);
    Integer selectUser();
}
