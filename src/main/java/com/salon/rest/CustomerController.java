/*********************************************************************************************     
 Description : Its acts as the RestController For Customer Module
  
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

import com.salon.bean.Customer;
import com.salon.service.CustomerServiceImpl;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class CustomerController 
{
	@Autowired
	CustomerServiceImpl customerservice;
	
/************************************************************************************************
	* Method Type        : PostMapping
	* Url path           : /addCustomer
	* Method Name        : addCustomer
	* Description        : To add the new Customer to the Database		                    
************************************************************************************************/	
	@PostMapping(path="/addCustomer")
	public Customer addCustomer(@Valid @RequestBody Customer customer )
	{
		 customerservice.addCustomer(customer);
		return customer;
	}
/************************************************************************************************
	* Method Type        : DeleteMapping
	* Url path           : /removeCustomer/{userId}
	* Method Name        : removeCustomer
	* Description        : To remove the Existing Customer from the Database by using ID	                    
************************************************************************************************/	
	@DeleteMapping(path="/removeCustomer/{userId}")
	public String removeCustomer(@PathVariable int userId) throws Exception
	{
		String s1 = customerservice.removeCustomer(userId);
				return s1;
    }
	
/************************************************************************************************
	* Method Type        : GetMapping
	* Url path           : /getCustomer/{userId}
	* Method Name        : getCustomer
	* Description        : To get the Existing Customer from the Database by using ID	                    
************************************************************************************************/
	@GetMapping(path="/getCustomer/{userId}")
	public ResponseEntity<Customer> getCustomer(@PathVariable int userId) throws Exception
	{
		Customer c1=customerservice.getCustomer(userId);
		
		ResponseEntity re=new ResponseEntity<Customer>(c1,HttpStatus.OK);
		return re;
	}
	
/************************************************************************************************
	* Method Type        : PutMapping
	* Url path           : /updateCustomer
	* Method Name        : updateCustomer
	* Description        : To Update the Existing Service from the Database by using ID	                    
************************************************************************************************/	
	@PutMapping(path="/updateCustomer")
	public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer c) throws Exception
	{
		Customer c1=customerservice.updateCustomer(c);
		
		ResponseEntity re=new ResponseEntity<Customer>(c1,HttpStatus.OK);
		return re;
	}
	
/************************************************************************************************
	* Method Type        : GetMapping
	* Url path           : /getAllCustomers
	* Method Name        : getAllCustomers
	* Description        : To get All the Existing Customers from the Database in the form of List	                    
************************************************************************************************/	
	@GetMapping(path="/getAllCustomers")
	public ResponseEntity<List<Customer>> getAllCustomers()
	{
		List<Customer> le=customerservice.getAllCustomers();
		
		ResponseEntity re=new ResponseEntity<List<Customer>>(le,HttpStatus.OK);
		return re;
	}
	
/************************************************************************************************
	* Method Type        : GetMapping
	* Url path           : /getCustomersBy/{city}
	* Method Name        : getByCity
	* Description        : To get All the Existing Customers from the Database by their City	                    
************************************************************************************************/	
	@GetMapping(path = "/getCustomersBy/{city}" )
    public ResponseEntity<List<Customer>> getByCity(@PathVariable String city) 
	{
		  List<Customer> le = this.customerservice.getByCity(city);
		  ResponseEntity re = new ResponseEntity(le, HttpStatus.OK);
		  return re;
	}
}


