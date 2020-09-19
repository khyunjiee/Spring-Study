package com.hyunji.study.controller;

import com.hyunji.study.model.User;
import com.hyunji.study.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

//    private UserDaoService service;
//
//    public UserController(UserDaoService service) {
//        this.service = service;
//    }
//
//    @GetMapping("/users")
//    public List<User> AllUsers() {
//        return service.findAll();
//    }
//
//    @GetMapping("/users/{id}")
//    public User findOne(@PathVariable int id) {
//        return service.findOne(id);
//    }
//
//    @PostMapping("/users")
//    public void createUser(@RequestBody User user) {
//        User save = service.save(user);
//    }

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity AllUsers() {
        return new ResponseEntity(userService.getAllUser(), HttpStatus.OK);
    }

    @GetMapping("/users/{idx}")
    public ResponseEntity FindUser(@PathVariable int idx) {
        return new ResponseEntity(userService.findUser(idx), HttpStatus.OK);
    }

}
