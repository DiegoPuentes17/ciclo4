
package com.ciclo4.controller;

import com.ciclo4.model.User;
import com.ciclo4.service.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    //GET ALL USER
    @GetMapping("/all")
    public List<User> getUser(){
        return  userService.getAllUser();
    }
    
    //GET EMAIL
    @GetMapping("/{email}")
    public boolean getUserEmail(@PathVariable("email") String email){
        return userService.getUserEmail(email);
    }
    //GET EMAIL AND PASSWORD
    @GetMapping("/{email}/{password}")
    public User getUserAccount(@PathVariable("email") String email, @PathVariable("password") String password){
        return userService.getEmailAndPass(email, password);
    }
    
    //POST USER
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }
}
