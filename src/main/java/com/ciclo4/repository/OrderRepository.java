
package com.ciclo4.repository;

import com.ciclo4.model.Order;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {
    
    @Autowired
    OrderCrudRepository orderCrudRepository;
    
    //Obtener todas las ordenes
    public List<Order> getAllOrder(){
        return (List<Order>) orderCrudRepository.findAll();
    }
    
    //Obtener orden
    public Optional<Order> getOrder(int id){
        return orderCrudRepository.findById(id);
    }
    
    //Almacenar orden a la base de datos
    public Order saveOrder(Order order){
        return orderCrudRepository.save(order);
    }
    
    public void deleteOrder( Integer id){
        orderCrudRepository.deleteById(id);
    }
    
    /**
     *
     * @param zone
     * @return
     */
    public List<Order> getAllZone(String zone){
        return orderCrudRepository.findByZone(zone);
    }
}
