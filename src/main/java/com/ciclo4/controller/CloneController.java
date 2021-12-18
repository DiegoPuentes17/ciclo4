package com.ciclo4.controller;

import com.ciclo4.model.Clone;
import com.ciclo4.service.CloneService;
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
@RequestMapping("api/clone")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class CloneController {
    
    @Autowired
    private CloneService cloneService;
    
    //GET ALL CLONE
    @GetMapping("/all")
    public List<Clone> getClone(){
      return cloneService.getAllClone();
    }
    
    //POST CLONE
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Clone SaveClone(@RequestBody Clone clone){
        return cloneService.saveClone(clone);
    }
    
    //POST CLONE
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Clone updateClone(@RequestBody Clone clone){
        return cloneService.updateClone(clone);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClone(@PathVariable("id") Integer id){
        cloneService.deleteClone(id);
    }
    
    //GET ALL CLONEPRICE
    @GetMapping("/price/{price}")
    public List<Clone> getClonePrice(@PathVariable("price") double price){
      return cloneService.getClonePrice(price);
    }
    
    //GET ALL CLONEDESCRIPTION
    @GetMapping("/description/{description}")
    public List<Clone> getCloneDescription(@PathVariable("description") String description){
      return cloneService.getContainsCloneDescription(description);
    }

}
