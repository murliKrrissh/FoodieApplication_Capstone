package com.example.UserAuthService.service;

import com.example.UserAuthService.Exception.InvalidCredentialsException;
import com.example.UserAuthService.Exception.UserAlreadyExistsException;
import com.example.UserAuthService.domain.User;
import com.example.UserAuthService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    private UserRepository userRepository;
@Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    @Override
    public User register(User user) throws UserAlreadyExistsException {
        if(userRepository.findById(user.getEmail()).isPresent())
        {
            throw new UserAlreadyExistsException();
        }
        return userRepository.save(user);
    }

    @Override
    public User login(User user) throws InvalidCredentialsException {
        if(userRepository.findById(user.getEmail()).isPresent()){
            return userRepository.findByEmailAndPassword(user.getEmail(),user.getPassword());
        }
        else
            throw new InvalidCredentialsException();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public boolean deleteUser(String email) {
        User user = userRepository.findById(email).get();
        if(user.getEmail().equals(email)){
            userRepository.deleteById(email);
        }
        return true;
    }
}
