package com.example.msh2rating.service;

import com.example.msh2rating.model.User;
import com.example.msh2rating.dto.UserRequest;
import com.example.msh2rating.dto.UserResponse;

import java.util.concurrent.CopyOnWriteArrayList;

public interface IUserService {
    UserResponse createUser(UserRequest usr);
    CopyOnWriteArrayList<User> getUsers();
    void updateUser(String id, UserRequest usr);
    void deleteUser(String id);
}