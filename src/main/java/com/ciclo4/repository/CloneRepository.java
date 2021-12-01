/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ciclo4.repository;

import com.ciclo4.model.Clone;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author diego
 */
@Repository
public class CloneRepository {
    
    @Autowired
    private CloneCrudRepository cloneCrudRepository;
    
    public List<Clone> getAllClone(){
        return (List<Clone>) cloneCrudRepository.findAll();
    }
    
    public Optional<Clone> getClone(int id){
        return cloneCrudRepository.findById(id);
    }
    
    public Clone saveClone(Clone clone){
        return cloneCrudRepository.save(clone);
    }
    
    public void deleteClone(Integer id){
        cloneCrudRepository.deleteById(id);
    }
    
}
