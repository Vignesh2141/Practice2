package com.neosoft.User.controller;

import com.neosoft.User.model.ResponseTempleteVO;
import com.neosoft.User.model.UserModel;
import com.neosoft.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/save")
    public void saveUser(@RequestBody UserModel userModel){
        userService.saveUser(userModel);
    }

    @GetMapping("/get/{id}")
    public UserModel getUserById(@PathVariable String id){
        return userService.getUserById(id);
    }

    @GetMapping("/get")
    public List<UserModel> getAllUsers(){
        return userService.getUsers();
    }

    @GetMapping("/get/departments/{userId}")
    public ResponseTempleteVO getUserAndDepartment(@PathVariable String userId){
        return userService.getUserWithDepartment(userId);
    }
}
