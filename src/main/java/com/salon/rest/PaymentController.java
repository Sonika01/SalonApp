/*********************************************************************************************     
 Description : Its acts as the RestController For Payment Module
  
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

import com.salon.bean.Payment;
import com.salon.service.IPaymentService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class PaymentController 
{
	
	@Autowired
	IPaymentService paymentservice;

/************************************************************************************************
	* Method Type        : PostMapping
	* Url path           : /addPayment
	* Method Name        : addPayment
	* Description        : To add the new Payment to the Database		                    
************************************************************************************************/	
	@PostMapping(path="/addPayment")
	public Payment addPayment( @Valid  @RequestBody Payment payment) 
	{
		Payment p=paymentservice.addPayment(payment);
		return p;
	}
	
/************************************************************************************************
	* Method Type        : DeleteMapping
	* Url path           : /removeService/{id}
	* Method Name        : removePayment
	* Description        : To remove the Existing Payment from the Database	by using ID	                    
************************************************************************************************/	
	@DeleteMapping(path="/removePayment/{id}")
	public String removePayment(@PathVariable Long id) throws Exception 
	{
		paymentservice.removePayment(id);
			return "errorrr";
	}
/************************************************************************************************
	* Method Type        : PutMapping
	* Url path           : /updatePayment/{paymentId}
	* Method Name        : updatePaymentById
	* Description        : To Update the Existing Payment from the Database by using ID	                    
************************************************************************************************/	
	@PutMapping(path="/updatePayment/{paymentId}")
	public ResponseEntity<Payment> updatePaymentById(@Valid @RequestBody Payment p)throws Exception 
	{
		Payment p1=paymentservice.updatePayment(p);
		ResponseEntity<Payment> re=new ResponseEntity<Payment>(p1,HttpStatus.OK);
		return re;
	}
	
/************************************************************************************************
	* Method Type        : GetMapping
	* Url path           : /getPaymentDetails/{id}
	* Method Name        : getPaymentDetails
	* Description        : To get the Existing Payment Details from the Database by using ID	                    
************************************************************************************************/	
	@GetMapping(path="/getPaymentDetails/{id}")
	public ResponseEntity<Payment> getPaymentDetails(@PathVariable long id) throws Exception
	{
	Payment p1=paymentservice.getPaymentDetails(id);
	ResponseEntity re=new ResponseEntity<Payment>(p1,HttpStatus.OK);
	return re;
	}
	
/************************************************************************************************
	* Method Type        : GetMapping
	* Url path           : /getAllPaymentDetails
	* Method Name        : getAllPaymentDetails
	* Description        : To get All the Existing Payment Details from the Database in the form of List	                    
************************************************************************************************/	
	@GetMapping(path="/getAllPaymentDetails")
	public ResponseEntity<List>getAllPaymentDetails()
	{
		List<Payment> p1=paymentservice.getAllPaymentDetails();
		ResponseEntity re=new ResponseEntity<List>(p1,HttpStatus.OK);
		return re;
	}

}
