
package com.ciclo4.repository;

import com.ciclo4.model.Order;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public List<Order> getSalesManId(Integer id){
        return orderCrudRepository.findBySalesManId(id);
    }
    
    public List<Order> getSalesManStatus(Integer id, String status){
        return orderCrudRepository.findBySalesManIdAndStatus(id, status);
    }
    
    public List<Order> getRegisterDayAndSalesMan(String registerDay, Integer salesManId){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            return orderCrudRepository.findByRegisterDayAndSalesManId(new SimpleDateFormat("yyyy-MM-dd").parse(registerDay), salesManId);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
