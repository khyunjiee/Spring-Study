package com.hyunji.study.controller;

import com.hyunji.study.model.User;
import com.hyunji.study.service.UserDaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserDaoService service;

    public UserController(UserDaoService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> AllUsers() {
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public User findOne(@PathVariable int id) {
        return service.findOne(id);
    }

    @PostMapping("/users")
    public void createUser(@RequestBody User user) {
        User save = service.save(user);
    }

}
