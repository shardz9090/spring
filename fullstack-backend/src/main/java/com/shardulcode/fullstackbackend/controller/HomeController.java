package com.shardulcode.fullstackbackend.controller;

import com.shardulcode.fullstackbackend.exception.UserNotFoundException;
import com.shardulcode.fullstackbackend.model.User;
import com.shardulcode.fullstackbackend.repository.Userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")
public class HomeController {
    @Autowired
    private Userrepository userrepository;
    @PostMapping("/user")
    User newUser(@RequestBody User newUser){
        return userrepository.save(newUser);
    }
    @GetMapping("/users")
    List<User> getallusers(){
        return userrepository.findAll();
    }
    @GetMapping("user/{id}")
    User getUserbyId(@PathVariable Long id){
        return userrepository.findById(id).orElseThrow(()->new UserNotFoundException(id));
    }
    @PutMapping("user/{id}")
    User updateUser(@RequestBody User newUser, @PathVariable Long id){
        return userrepository.findById(id).map(user -> {
            user.setEmail(newUser.getEmail());
            user.setName(newUser.getName());
            user.setUsername((newUser.getUsername()));
            return userrepository.save(user);
        }).orElseThrow(()->new UserNotFoundException(id));
    }
    @DeleteMapping("user/{id}")
    String deleteUser(@PathVariable Long id){
        if(!userrepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        userrepository.deleteById(id);
        return "User with id " + id + " Has been deleted";
    }
}
