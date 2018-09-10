package com.xx.dao;

import com.xx.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    int addUser(@Param("user") User user);
    int delUser(@Param("id") int id);
    int update(@Param("user") User user);
    User findById(@Param("id") int id);
    List<User> findAll();
    List<User> find(@Param("name") String name, @Param("age") int age);
}
