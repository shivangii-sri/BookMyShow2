package com.BookMyShow.service;

import com.BookMyShow.entities.User;
import com.BookMyShow.exceptions.RecordNotFoundException;
import com.BookMyShow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void createUser(User user){
        userRepository.save(user);
    }

    public void updateUser(User user){
        User existingUser = userRepository.findById(user.getId())
                .orElseThrow(()-> new RecordNotFoundException("User Id ", String.valueOf(user.getId())));

        if(user.getName()!=null && !user.getName().isEmpty() ) existingUser.setName(user.getName());
        if(user.getEmail()!=null && !user.getEmail().isEmpty()) existingUser.setEmail(user.getEmail());
        if(user.getPhone()!=null && !user.getPhone().isEmpty()) existingUser.setPhone(user.getPhone());
        if(user.getLocation()!=null) existingUser.setLocation(user.getLocation());
        userRepository.save(existingUser);
    }

    public User getUserById(Long userId){
        User user=userRepository.getReferenceById(userId);
        return user;

//        Optional<User> user = userRepository.findById(userId);
//
//        if(user == null){
//            System.out.println("User does not exist!!");
//        }
//        return user;
    }
}
