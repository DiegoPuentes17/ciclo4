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
    
    public User getUser(Integer id){
        return userRepository.getUser(id).orElse(new User());
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
            
            return new User();
        }
  
        
    }
    
    //guardar usuario
    public User saveUser(User user){
        if( user.getName() == null || user.getEmail() == null || user.getPassword() == null || user.getIdentification() == null || user.getType() == null){
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
    //Actualizar usuario
    public User UpdateUser(User user){
        if(user.getId()!=null){
            Optional<User> userExist = userRepository.getUser(user.getId());

            if (userExist.isPresent()) {
                if (user.getIdentification()!= null) {
                    userExist.get().setIdentification(user.getIdentification());   
                }
                if (user.getName()!= null) {
                    userExist.get().setName(user.getName());   
                }
                if (user.getBirthtDay()!= null) {
                    userExist.get().setBirthtDay(user.getBirthtDay());
                }
                if (user.getMonthBirthtDay()!= null) {
                    userExist.get().setMonthBirthtDay(user.getMonthBirthtDay());   
                }
                if (user.getAddress()!= null) {
                    userExist.get().setAddress(user.getAddress());   
                }
                if (user.getCellPhone()!= null) {
                    userExist.get().setCellPhone(user.getCellPhone());  
                }
                if (user.getEmail()!= null) {
                    userExist.get().setEmail(user.getEmail());   
                }
                if (user.getPassword()!= null) {
                    userExist.get().setPassword(user.getPassword());   
                }
                if (user.getZone()!= null) {
                    userExist.get().setZone(user.getZone());   
                }
                if (user.getType()!= null) {
                    userExist.get().setType(user.getType());   
                }
                return userRepository.saveUser(userExist.get());
            }else{
                
                return user;
            }
        }else{
            return user;
        }
    }

    //Eliminar usuario
    public Integer deleteUser(Integer id){
       Optional<User> user = userRepository.getUser(id);
       
       if(user.isPresent()){
           userRepository.deleteUser(id);
           return null;
       }else{
           return id;
       }
    }
    
    public List<User> getMonthBirthtDay(String month){
        return userRepository.getMonthBirthtDay(month);
    }
}  
