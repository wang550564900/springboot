package com.itheima.service;

import com.itheima.domain.User;

import java.util.List;

public interface IUserService {
    /**
     * 根据名称查询所有用户
     */
    List<User> findAllUser(String name);
    List<User>findAll();
}
