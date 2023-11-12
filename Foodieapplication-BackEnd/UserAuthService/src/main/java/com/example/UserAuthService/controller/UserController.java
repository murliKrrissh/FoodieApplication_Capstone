package com.example.UserAuthService.controller;


import com.example.UserAuthService.Exception.InvalidCredentialsException;
import com.example.UserAuthService.Exception.UserAlreadyExistsException;
import com.example.UserAuthService.domain.User;
import com.example.UserAuthService.domain.UserDto;
import com.example.UserAuthService.security.SecurityTokenGenerator;
import com.example.UserAuthService.service.IUserService;
import com.example.UserAuthService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/auth")
public class UserController {
    private IUserService iUserService;
    private SecurityTokenGenerator securityTokenGenerator;

    @Autowired
    public UserController(IUserService iUserService,SecurityTokenGenerator securityTokenGenerator) {
        this.iUserService = iUserService;
        this.securityTokenGenerator = securityTokenGenerator;
    }
    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody UserDto userDto) throws UserAlreadyExistsException {
        User user = new User(userDto.getEmail(), userDto.getPassword(), userDto.getName(), userDto.getRole(),
                userDto.getAddress(), userDto.getPhoneNo());
        return new ResponseEntity<>(iUserService.register(user),HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) throws InvalidCredentialsException
    {
        User presentUser = iUserService.login(user);
        if (presentUser == null) {
            throw new InvalidCredentialsException();
        }
        return new ResponseEntity<>(securityTokenGenerator.storeToken(presentUser),HttpStatus.OK);
    }

    @GetMapping("/savedUser")
    public List<User> showSavedUsers(){
        return iUserService.getAllUsers();
    }

    @DeleteMapping("/deleteUserByEmail/{email}")
    public ResponseEntity<?> removeUser(@PathVariable String email){
        boolean result = iUserService.deleteUser(email);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}

