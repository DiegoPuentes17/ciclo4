package com.ciclo4.repository;

import com.ciclo4.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

//interface metodos CRUD de la Clase USER
public interface UserCrudRepository  extends MongoRepository<User, Integer>{
    
    /**
     *
     * @param email
     * @return
     */
    public Optional<User> findByEmail(String email);
    
    /**
     *
     * @param name
     * @return
     */
    public Optional<User> findByName(String name);
    
    /**
     *
     * @param email
     * @param password
     * @return
     */
    public Optional<User> findByEmailAndPassword(String email, String password);
    
    public List<User> findByMonthBirthtDay(String month);
}
