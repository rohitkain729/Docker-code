package com.app.controller;

import com.app.entity.User;
import com.app.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository rep;

    @GetMapping
    public String UserData() {
        return "User";
    }


    @PostMapping
    public String saveUserData(@RequestBody User user) {
        rep.save(user);
        return "User Saved";
    }

    @GetMapping("/users")
    public List<User> getData() {
        return rep.findAll();
    }

}
