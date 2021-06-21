/*********************************************************************************************     
 Description : Its acts as the RestController For Salon Service Module
  
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

import com.salon.bean.SalonService;
import com.salon.service.SalonServiceImpl;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class SalonServiceController 
{
	@Autowired
	SalonServiceImpl salonservice;
	
/************************************************************************************************
	* Method Type        : PostMapping
	* Url path           : /addService
	* Method Name        : addService
	* Description        : To add the new Service to the Database		                    
************************************************************************************************/
	@PostMapping(path="/addService")
	public ResponseEntity<SalonService> addService(@Valid @RequestBody SalonService salonService)
	{
		SalonService s1=salonservice.addService(salonService);	
		ResponseEntity re=new ResponseEntity<SalonService>(s1,HttpStatus.OK);
			return re;
	}
	
/************************************************************************************************
	* Method Type        : DeleteMapping
	* Url path           : /removeService/{id}
	* Method Name        : removeService
	* Description        : To remove the Existing Service from the Database	by using ID	                    
************************************************************************************************/
	@DeleteMapping(path="/removeService/{id}") 
	public ResponseEntity<String> removeService(@PathVariable Long id) throws Exception
	{
		 salonservice.removeService(id);	
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
			return re;
	}

/************************************************************************************************
	* Method Type        : GetMapping
	* Url path           : /getService/{id}
	* Method Name        : getService
	* Description        : To get the Existing Service from the Database by using ID	                    
************************************************************************************************/
	@GetMapping(path="/getService/{id}") 
	public ResponseEntity<SalonService> getService(@PathVariable Long id) throws Exception
	{
		SalonService s1=salonservice.getService(id);
		
		ResponseEntity re=new ResponseEntity<SalonService>(s1,HttpStatus.OK);
		return re;	
	}
/************************************************************************************************
	* Method Type        : GetMapping
	* Url path           : /getAllServices
	* Method Name        : getAllServices
	* Description        : To get All the Existing Services from the Database in the form of List	                    
************************************************************************************************/
	@GetMapping(path="/getAllServices")
	public ResponseEntity<SalonService> getAllServices()
	{
		List<SalonService> ls=salonservice.getAllServices();
		ResponseEntity re=new ResponseEntity<List<SalonService>>(ls,HttpStatus.OK);
		return re;		
	}

/************************************************************************************************
	* Method Type        : PutMapping
	* Url path           : /updateService
	* Method Name        : updateService
	* Description        : To Update the Existing Service from the Database by using ID	                    
************************************************************************************************/
	@PutMapping(path="/updateService")
	public ResponseEntity<SalonService> updateService(@RequestBody SalonService salonService) throws Exception
	{
		SalonService s1= salonservice.updateService(salonService);
		ResponseEntity re=new ResponseEntity<SalonService>(s1,HttpStatus.OK);
		return re;	
	}
	
/************************************************************************************************
	* Method Type        : GetMapping
	* Url path           : /getServiceByName
	* Method Name        : getServiceByName
	* Description        : To get All the Existing Services from the Database by using the Name	                    
************************************************************************************************/
	@GetMapping(path="/getServiceByName")
	public ResponseEntity<List<SalonService>> getServiceByName(@RequestBody String ServiceName)
	{
		List<SalonService> l=salonservice.getServiceByName(ServiceName);	
		ResponseEntity re=new ResponseEntity<List<SalonService>>(l,HttpStatus.OK);
		return re;
	}
	
/************************************************************************************************
	* Method Type        : GetMapping
	* Url path           : /getServiceByPrice
	* Method Name        : getServiceByPrice
	* Description        : To get All the Existing Services from the Database by using the Price	                    
************************************************************************************************/
	@GetMapping(path="/getServiceByPrice")
	public ResponseEntity<List<SalonService>> getServiceByPrice(@RequestBody double servicePrice)
	{
		List<SalonService> l=salonservice.getServiceByPrice(servicePrice);	
		ResponseEntity re=new ResponseEntity<List<SalonService>>(l,HttpStatus.OK);
		return re;	
	}
	
/************************************************************************************************
	* Method Type        : GetMapping
	* Url path           : /getServiceByDuration
	* Method Name        : getServiceDuration
	* Description        : To get All the Existing Services from the Database by using the Duration	                    
************************************************************************************************/
	@GetMapping(path="/getServiceByDuration")
	public ResponseEntity<List<SalonService>> getServiceByDuration(@RequestBody String serviceDuration)
	{
		List<SalonService> l= salonservice.getServiceDuration(serviceDuration);
		ResponseEntity re=new ResponseEntity<List<SalonService>>(l,HttpStatus.OK);
		return re;
	}
}