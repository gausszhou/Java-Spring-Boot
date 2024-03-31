package com.example.javaspringboot.controller;

import com.example.javaspringboot.entity.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @ApiOperation("新增用户")
    @PostMapping("/user")
    public String addUser(User user) {
        return "user.add";
    }

    @ApiOperation("删除用户")
    @DeleteMapping("/user/{id}")
    public String deleteUserById(@PathVariable int id) {
        return "user.delete";
    }

    @ApiOperation("更新用户")
    @PutMapping("/user")
    public String updateUser(User user) {
        return "user.update";
    }

    @ApiOperation("获取用户")
    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable int id) {
        return "user.get";
    }

}
