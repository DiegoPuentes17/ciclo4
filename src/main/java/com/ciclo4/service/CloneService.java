package com.ciclo4.service;

import com.ciclo4.model.Clone;
import com.ciclo4.repository.CloneRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author diego
 */
@Service
public class CloneService {
    
    @Autowired
    private CloneRepository cloneRepository;
    
    public List<Clone> getAllClone(){
       return cloneRepository.getAllClone();
    }
    
    public Optional<Clone> getClone(Integer id){
        return cloneRepository.getClone(id);
    }
    
    
    public Clone saveClone(Clone clone) {

        if (clone.getBrand() == null) {
            return clone;
        } else {
            
            Optional<Clone> existCloneId = cloneRepository.getClone(clone.getId());
            if (existCloneId.isEmpty()) {
                return cloneRepository.saveClone(clone);
            } else {
                return clone;
            }
        }
        
    }
    
    //Actualizar clone
    public Clone updateClone(Clone clone){
        
        if (clone.getId()!= null) {
            Optional<Clone> cloneExist = cloneRepository.getClone(clone.getId());
            
            if (cloneExist.isPresent()) {
                
                if (clone.getBrand()!= null) {
                    cloneExist.get().setBrand(clone.getBrand());   
                }
                if (clone.getProcesor()!= null) {
                    cloneExist.get().setProcesor(clone.getProcesor());   
                }
                if (clone.getOs()!= null) {
                    cloneExist.get().setOs(clone.getOs());   
                }
                if (clone.getDescription()!= null) {
                    cloneExist.get().setDescription(clone.getDescription());   
                }
                if (clone.getMemory()!= null) {
                    cloneExist.get().setMemory(clone.getMemory());   
                }
                if (clone.getHardDrive()!= null) {
                    cloneExist.get().setHardDrive(clone.getHardDrive());   
                }
                if (clone.getPrice() != 0 ){
                    cloneExist.get().setPrice(clone.getPrice());
                }
                if (clone.getQuantity()!= 0) {
                    cloneExist.get().setQuantity(clone.getQuantity());   
                }
                if (clone.getPhotography()!= null) {
                    cloneExist.get().setPhotography(clone.getPhotography());   
                }
                return cloneRepository.saveClone(cloneExist.get()); 
            }else{
                return clone; 
            }
        }else{
            return clone;
        }
        
    }
    
    //Eliminar clone
    public Integer deleteClone(Integer id){
       Optional<Clone> clone = cloneRepository.getClone(id);
       
       if(clone.isPresent()){
           cloneRepository.deleteClone(id);
           return null;
       }else{
           return id;
       }
    }
}
