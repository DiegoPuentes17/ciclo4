package com.ciclo4.repository;

import com.ciclo4.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    
    @Autowired
    private UserCrudRepository userCrudRepository;
    
    //Obtener todos los usuarios
    public List<User> getAllUser(){
        return (List<User>) userCrudRepository.findAll();
    }
    
    //Obtener Usuario
    public Optional<User> getUser(int id){
        return userCrudRepository.findById(id);
    }
    
    //Obtener usuario con el email
    public Optional<User> getUserEmail(String email){
        
         return userCrudRepository.findByEmail(email);
    }
    
    //Obtener usuario con el nombre
    public Optional<User> getUserName(String name){
        
         return userCrudRepository.findByName(name);
    }
    
    //Obtener usuario con el email y password
    public Optional<User> getUsers(String email, String password){
         
         return userCrudRepository.findByEmailAndPassword(email, password);
    }
    
    //Almacenar usuario a la base de datos
    public User saveUser(User user){
        return userCrudRepository.save(user);
    }
    
    public void deleteUser( Integer id){
        userCrudRepository.deleteById(id);
    }
    
    public List<User> getMonthBirthtDay(String month){
        return userCrudRepository.findByMonthBirthtDay(month);
    }
            
}
