package com.ciclo4.service;

import com.ciclo4.model.User;
import com.ciclo4.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    //todos los usuarios
    public List<User> getAllUser(){
        return userRepository.getAllUser();
    }
    
    //usuario = email
    public boolean getUserEmail(String email){
        /*
        Optional<User> checkEmail = userRepository.getUserEmail(email);
        if (checkEmail.isEmpty()) {
            return false;
        }else{
            return true;
        }
        */
        
        return userRepository.getUserEmail(email).isPresent();
        
    }
    
    //usuario = email, password
    public User getEmailAndPass(String email, String password){
        Optional<User> userCheck = userRepository.getUsers(email, password);
        
        if (userCheck.isPresent()) {
           
            return userCheck.get();
        }else{
            
            return new User(null, email, password, "NO DEFINIDO" );
        }
  
        
    }
    
    //guardar usuario
    public User saveUser(User user){
        if( user.getName() == null || user.getEmail() == null || user.getPassword() == null){
            return user;
        }else{
            Optional<User> userCheck = userRepository.getUsers(user.getEmail(), user.getPassword());
            
            if(userCheck.isEmpty()){
                
                if (user.getId()== null) {
                    
                    return userRepository.saveUser(user);
                }else{
                    Optional<User> existUserId = userRepository.getUser(user.getId());
                    if(existUserId.isEmpty()){
                        return userRepository.saveUser(user);
                        
                    }else{
                        return user;
                    }
                }
                
            }else{
                return user;
            }
        }
    }
}  
