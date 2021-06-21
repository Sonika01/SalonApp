/*********************************************************************************************     
 Description : Its acts as the RestController For Order Module
  
 * @RestController --  This is applied to a class to mark it as a request handler. 
                       It is used to create RESTful web services using spring MVC. 
                                         					  
 * @RequestMapping --  It maps HTTP requests to handler methods of MVC and REST controllers. 
  
 * @RequestBody    --  By using it, you will get your values mapped with the model you created 
                       in your system for handling any specific call. 
  
 * @PathVariable   --  It is used to extract the values of the template variables and 
                       assign their value to a method variable. 
                       
 * @Valid          --  It marks a property, method parameter Or method return type for 
                       validation cascading. 
 ************************************************************************************************/
package com.salon.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salon.bean.Order;
import com.salon.service.OrderServiceImpl;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class OrderController
{
	@Autowired
	OrderServiceImpl orderservice;
	
/************************************************************************************************
	* Method Type        : PostMapping
	* Url path           : /addOrder
	* Method Name        : addOrder
	* Description        : To add the new Order to the Database		                    
************************************************************************************************/	
	@PostMapping(path="/addOrder")
	public ResponseEntity<Order> addOrder(@Valid @RequestBody Order order)
	{
	 		Order o1=orderservice.addOrder(order);	
			ResponseEntity re=new ResponseEntity<Order>(o1,HttpStatus.OK);
			return re;
			}
/************************************************************************************************
	* Method Type        : DeleteMapping
	* Url path           : /removeOrder/{id}
	* Method Name        : removeOrder
	* Description        : To remove the Existing Order from the Database	by using ID	                    
************************************************************************************************/	
	@DeleteMapping(path="/removeOrder/{id}")
	public ResponseEntity<String> removeOrder(@PathVariable Long id) throws Exception
	{
		orderservice.removeOrder(id);	
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
			return re;
	}
	
/************************************************************************************************
	* Method Type        : GetMapping
	* Url path           : /getAllOrders
	* Method Name        : getAllOrders
	* Description        : To get All the Existing Orders from the Database in the form of List	                    
************************************************************************************************/	
	@GetMapping(path="/getAllOrders")
	public ResponseEntity<Order> getAllOrders()
	{
		List<Order> ls=orderservice.getAllOrders();
		ResponseEntity re=new ResponseEntity<List<Order>>(ls,HttpStatus.OK);
		return re;		
	}
	
/************************************************************************************************
	* Method Type        : PutMapping
	* Url path           : /updateOrder
	* Method Name        : updateOrder
	* Description        : To Update the Existing Order from the Database by using ID	                    
************************************************************************************************/	
	@PutMapping(path="/updateOrder")
	public ResponseEntity<Order> updateOrder(@Valid @RequestBody Order order) throws Exception
	{
		Order e1= orderservice.updateOrder(order);
		ResponseEntity re=new ResponseEntity<Order>(e1,HttpStatus.OK);
		return re;	
	}

/************************************************************************************************
	* Method Type        : GetMapping
	* Url path           : /getOrderDetails/{id}
	* Method Name        : getOrderDetails
	* Description        : To get All the Existing Order Details from the Database in the form of List	                    
************************************************************************************************/		
	@GetMapping(path="/getOrderDetails/{id}") 
	public ResponseEntity<Order> getOrderDetails(@PathVariable Long id) throws Exception
	{
		Order o1=orderservice.getOrderDetails(id);
		
		ResponseEntity re=new ResponseEntity<Order>(o1,HttpStatus.OK);
		return re;	
	}
}
