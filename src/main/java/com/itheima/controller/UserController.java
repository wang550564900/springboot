package com.itheima.controller;

import com.itheima.domain.User;
import com.itheima.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @RequestMapping("/findAll/{name}")
    public List<User> findAllUser(@PathVariable("name") String name){
        List<User>users=userService.findAllUser(name);
        return users;
    }
    @RequestMapping("/findAll")
    public List<User>findAll(){
        List<User>users=userService.findAll();
        return users;
    }
    @RequestMapping("/hallo")
    public String say(){
        System.out.println("i love you java");
        return "i hate you for 999years";
    }
}

