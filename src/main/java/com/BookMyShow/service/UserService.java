package com.BookMyShow.service;

import com.BookMyShow.entities.User;
import com.BookMyShow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public void createUser(User user){
        userRepository.save(user);
    }
}
