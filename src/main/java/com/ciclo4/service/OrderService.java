
package com.ciclo4.service;


import com.ciclo4.model.Order;
import com.ciclo4.repository.OrderRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author diego
 */
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    
        //todos los usuarios
    public List<Order> getAllOrder(){
        return orderRepository.getAllOrder();
    }
    
    public Order getOrder(Integer id){
        return orderRepository.getOrder(id).orElse(new Order());
    }
    
    
    //guardar order
    public Order saveOrder(Order order){
        if( order.getProducts()== null || order.getRegisterDay() == null ){
            return order;
        }else{

            if (order.getId()== null) {

                return orderRepository.saveOrder(order);
            }else{
                Optional<Order> existOrderId = orderRepository.getOrder(order.getId());
                if(existOrderId.isEmpty()){
                    return orderRepository.saveOrder(order);

                }else{
                    return order;
                }
            }
                

        }
    }
    
    //Actualizar order
    public Order UpdateOrder(Order order){
        if(order.getId()!=null){
            Optional<Order> orderExist = orderRepository.getOrder(order.getId());

            if (orderExist.isPresent()) {
                if (order.getProducts()!= null) {
                    orderExist.get().setProducts(order.getProducts());   
                }
                if (order.getRegisterDay()!= null) {
                    orderExist.get().setRegisterDay(order.getRegisterDay());   
                }
                if (order.getStatus()!= null) {
                    orderExist.get().setStatus(order.getStatus());   
                }
                if (order.getSalesMan()!= null) {
                    orderExist.get().setSalesMan(order.getSalesMan());   
                }
                if (order.getProducts()!= null) {
                    orderExist.get().setProducts(order.getProducts());   
                }
                if (order.getQuantities()!= null) {
                    orderExist.get().setQuantities(order.getQuantities());  
                }
                
                return orderRepository.saveOrder(orderExist.get());
            }else{
                
                return order;
            }
        }else{
            return order;
        }
    }

    //Eliminar usuario
    public Integer deleteOrder(Integer id){
       Optional<Order> order = orderRepository.getOrder(id);
       
       if(order.isPresent()){
           orderRepository.deleteOrder(id);
           return null;
       }else{
           return id;
       }
    }
    
    //Get all ZONE
    public List<Order> getZone(String zone){
        
        return orderRepository.getAllZone(zone);
    }
    
}
