package com.community.springmvcjsonview.controller;

import com.community.springmvcjsonview.entity.User;
import com.community.springmvcjsonview.service.UserService;
import com.community.springmvcjsonview.view.Views;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // GET all users (without orders)
    @GetMapping
    @JsonView(Views.UserSummary.class)
    public List<User> getUsers(){
        return userService.getAllUsers();
    }

    // GET specific user (with orders)
    @GetMapping("/{id}")
    @JsonView(Views.UserDetails.class)
    public User getUser(@PathVariable Long id){
        return userService.getUser(id);
    }

    // CREATE user
    @PostMapping
    public User createUser(@Valid @RequestBody User user){
        return userService.saveUser(user);
    }

    // UPDATE user
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user){
        user.setId(id);
        return userService.saveUser(user);
    }

    // DELETE user
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}