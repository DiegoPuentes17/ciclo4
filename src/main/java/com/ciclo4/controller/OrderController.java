package com.ciclo4.controller;

import com.ciclo4.model.Order;
import com.ciclo4.service.OrderService;
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
@RequestMapping("api/order")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class OrderController {
   
    @Autowired
    private OrderService orderService;
    
    //GET ALL order
    @GetMapping("/all")
    public List<Order> getOrder(){
        return  orderService.getAllOrder();
    }
    
    
    //POST Order
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order saveUser(@RequestBody Order order){
        return orderService.saveOrder(order);
    }
    
    /**
     *
     * @param order
     * @return
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order Update(@RequestBody Order Order){
        return orderService.UpdateOrder(Order);
    }
    
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id){
        orderService.deleteOrder(id);
    }
    
    @GetMapping("/{id}")
    public Order getOrder(@PathVariable("id") Integer id){
        return orderService.getOrder(id);
    }
    
    @GetMapping("/zona/{zone}")
    public List<Order> getZone(@PathVariable("zone") String zone){
        return orderService.getZone(zone);
    }
    
    @GetMapping("/salesman/{id}")
    public List<Order> getSalesManId(@PathVariable("id") Integer id){
        return orderService.getSalesManId(id);
    }
            
    @GetMapping("/state/{status}/{id}")
    public List<Order> getSalesManStatus(@PathVariable("id") Integer id, @PathVariable("status") String status){
        return orderService.getSalesManStatus(id, status);
    }
    @GetMapping("/date/{registerDay}/{salesManId}")
    public List<Order> getRegisterDayAndSaleManId(@PathVariable("registerDay") String registerDay, @PathVariable("salesManId") Integer salesmanId){
        return orderService.getRegisterDayAndSalesMan(registerDay, salesmanId);
    }
}


