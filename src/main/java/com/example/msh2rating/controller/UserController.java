package com.example.msh2rating.controller;

import com.example.msh2rating.model.User;
import com.example.msh2rating.dto.UserRequest;
import com.example.msh2rating.dto.UserResponse;
import com.example.msh2rating.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import javax.validation.Valid;

@RestController
@RequestMapping("/onespan")
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping(
        value = "/user",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public UserResponse createUser(@Valid @RequestBody UserRequest usr) {
        return userService.createUser(usr);
    }

    @GetMapping(
        value = "/user",
        produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getUser() {
        return userService.getUsers();
    }

    @PutMapping(
        value = "/user/{id}",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void updateUser(@PathVariable("id") String id,
        @RequestBody UserRequest usr) {
        userService.updateUser(id, usr);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable("id") String id) {
        userService.deleteUser(id);
    }
}