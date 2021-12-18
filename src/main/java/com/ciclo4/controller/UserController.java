
package com.ciclo4.controller;

import com.ciclo4.model.User;
import com.ciclo4.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UserController {
    
    @Autowired
    private UserService userService;
    
    //GET ALL USER
    @GetMapping("/all")
    public List<User> getUser(){
        return  userService.getAllUser();
    }
    
    //GET EMAIL
    @GetMapping("/emailexist/{email}")
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
    
    /**
     *
     * @param user
     * @return
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User Update(@RequestBody User user){
        return userService.UpdateUser(user);
    }
    
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id){
        userService.deleteUser(id);
    }
    
    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Integer id){
        return userService.getUser(id);
    }
    
    //GET EMAIL
    @GetMapping("/birthday/{month}")
    public List<User> getMonthBirthDay(@PathVariable("month") String month){
        return userService.getMonthBirthtDay(month);
    }
}
