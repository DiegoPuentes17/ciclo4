
package com.ciclo4.repository;

import com.ciclo4.model.Order;
import java.util.Date;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author diego
 */
public interface OrderCrudRepository extends MongoRepository<Order, Integer> {
    
    @Query("{'salesMan.zone':?0}")
    public List<Order> findByZone(String zone);
    
    @Query("{'salesMan.id':?0}")
    List<Order> findBySalesManId(Integer id);
    
    List<Order> findBySalesManIdAndStatus(Integer id, String status); 
    
    List<Order> findByRegisterDayAndSalesManId(Date registerDay, Integer salesManId);
    
    
    

}
