
package com.ciclo4.repository;

import com.ciclo4.model.Clone;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author diego
 */
public interface CloneCrudRepository extends MongoRepository<Clone, Integer>{
    
    public List<Clone> findByPrice(double price);
    public List<Clone> findByDescriptionContainingIgnoreCase(String description);
}
