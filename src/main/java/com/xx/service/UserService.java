package com.xx.service;

import com.xx.entity.User;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface UserService {
    int addUser(User user);
    int delUser(int id);
    int update(User user);
    User findById(int id);
    List<User> findAll();
    PageInfo<User> getUserList(int pageNum, int pageSize, String name, int age);
}
