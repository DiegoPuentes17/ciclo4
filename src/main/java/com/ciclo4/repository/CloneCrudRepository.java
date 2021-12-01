
package com.ciclo4.repository;

import com.ciclo4.model.Clone;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author diego
 */
public interface CloneCrudRepository extends MongoRepository<Clone, Integer>{
    
}
