package com.example.UserAuthService.service;

import com.example.UserAuthService.Exception.InvalidCredentialsException;
import com.example.UserAuthService.Exception.UserAlreadyExistsException;
import com.example.UserAuthService.domain.User;

import java.util.List;

public interface IUserService {

    User register(User user) throws UserAlreadyExistsException;
    User login(User user)throws InvalidCredentialsException;
    List<User> getAllUsers();
    boolean deleteUser(String email);




}
