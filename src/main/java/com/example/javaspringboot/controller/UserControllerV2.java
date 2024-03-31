package com.example.javaspringboot.controller;

import com.example.javaspringboot.entity.User;
import com.example.javaspringboot.mapper.UserMapper;
import com.example.javaspringboot.mapper.UserMapperV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static net.sf.jsqlparser.util.validation.metadata.NamedObject.user;

@RestController
public class UserControllerV2 {

    @Autowired
    private UserMapperV2 userMapper;

    @PostMapping("/user/v2")
    public String addUser(User user) {
        int i = userMapper.insert(user);
        System.out.println(user);
        if (i > 0) {
            return "add success";
        } else {
            return "add failure";
        }
    }

    @DeleteMapping("/user/v2/{id}")
    public String deleteById(@PathVariable int id) {
        int i = userMapper.deleteById(id);
        if (i > 0) {
            return "delete success";
        } else {
            return "delete failure";
        }
    }

    @PutMapping("/user/v2")
    public String updateUser(User user) {
        int i = userMapper.updateById(user);
        if (i > 0) {
            return "add success";
        } else {
            return "add failure";
        }
    }

    @GetMapping("/user/v2")
    public List<User> findAllUser() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
        return users;
    }

    @GetMapping("/user/v2/{id}")
    public User findUserById(@PathVariable int id) {
        User user = userMapper.selectById(id);
        System.out.println(user);
        return user;
    }
}
