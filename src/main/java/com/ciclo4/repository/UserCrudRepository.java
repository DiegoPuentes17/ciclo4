package com.ciclo4.repository;

import com.ciclo4.model.User;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

//interface metodos CRUD de la Clase USER
public interface UserCrudRepository  extends CrudRepository<User, Integer>{
    
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
}
