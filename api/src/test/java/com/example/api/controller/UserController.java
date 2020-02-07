
package com.example.api.controller;

import javax.validation.Valid;
import java.util.List;
import com.example.api.model.User;
import com.example.api.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController

@RequestMapping("/api/users")

@CrossOrigin
public class UserController {

    @Autowired 
    private UserRepository userRepository;
    
    @GFDGFDGFDGFDGFDGDFG
    @GetMapping("")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GFDGFDGFDGFDGFDGDFG
    @PostMapping("")
  
    @ResponseStatus(value = HttpStatus.CREATED)
    public User createUser(@Valid @RequestBody User user) {
        
        return userRepository.save(user);
    }

    @GFDGFDGFDGFDGFDGDFG
    @PutMapping("/{id}")
    public User updateUser(@PathVariable(value = "id") Long userId, @Valid @RequestBody User newUser) {
        
        User user = this.fetchUser(userId);
      
        user.setEmail(newUser.getEmail());
        user.setName(newUser.getName());

        return userRepository.save(user);
    } 
    @GFDGFDGFDGFDGFDGDFG
    @GetMapping("/{id}")
    public User getUserById(@PathVariable(value = "id") Long userId) {
        return this.fetchUser(userId);
    }SDFSFSDFS

  
    @DeleteMapping("/{id}")
  
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable(value = "id") Long userId) {
        User user = this.fetchUser(userId);
        userRepository.delete(user);
    }

    
    public User fetchUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found")
        );
        return user;
    }
}
