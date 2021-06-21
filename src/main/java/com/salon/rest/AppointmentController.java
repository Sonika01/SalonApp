/*********************************************************************************************     
 Description : Its acts as the RestController For Appointment Module
  
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
import java.util.Optional;

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

import com.salon.bean.Appointment;
import com.salon.service.AppointmentServiceImpl;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class AppointmentController 
{
	@Autowired
	AppointmentServiceImpl appointmentService;

/************************************************************************************************
	* Method Type        : PostMapping
	* Url path           : /addAppointment
	* Method Name        : addAppointment
	* Description        : To add the new Appointment to the Database		                    
************************************************************************************************/
	@PostMapping(path="/addAppointment")
	public ResponseEntity<Appointment> addAppointment(@Valid @RequestBody Appointment appointment)
	{
		Appointment a1=appointmentService.addAppointment(appointment);	
		ResponseEntity re=new ResponseEntity<Appointment>(a1,HttpStatus.OK);
		return re;
	}
	
/************************************************************************************************
	* Method Type        : DeleteMapping
	* Url path           : /removeAppointment/{id}
	* Method Name        : removeAppointment
	* Description        : To remove the Existing Appointment from the Database by using ID	                    
************************************************************************************************/	
	@DeleteMapping(path="/removeAppointment/{id}")
	public ResponseEntity<String> removeAppointment(@PathVariable Long id)
	{
		appointmentService.removeAppointment(id);	
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}	
/************************************************************************************************
	* Method Type        : GetMapping
	* Url path           : /getAppointment/{id}
	* Method Name        : getAppointment
	* Description        : To get the Existing Appointment from the Database by using ID	                    
************************************************************************************************/	
	@GetMapping(path="/getAppointment/{id}")
	public ResponseEntity<Appointment> getAppointment(@PathVariable Long id)
	{
		Optional<Appointment> a1=appointmentService.getAppointment(id);
		ResponseEntity re=new ResponseEntity <Optional<Appointment>>(a1,HttpStatus.OK);
		return re;	
	}
	
/************************************************************************************************
	* Method Type        : GetMapping
	* Url path           : /getAllAppointments
	* Method Name        : getAllAppointments
	* Description        : To get All the Existing Appointments from the Database in the form of List	                    
************************************************************************************************/	
	@GetMapping(path="/getAllAppointments")
	public ResponseEntity<Appointment> getAllAppointments()
	{
		List<Appointment> ls=appointmentService.getAllAppointments();
		ResponseEntity re=new ResponseEntity<List<Appointment>>(ls,HttpStatus.OK);
		return re;	
	}
	
/************************************************************************************************
	* Method Type        : PutMapping
	* Url path           : /updateAppointment
	* Method Name        : updateAppointment
	* Description        : To Update the Existing Appointment from the Database by using ID	                    
************************************************************************************************/	
	@PutMapping(path="/updateAppointment") 
	public ResponseEntity<Appointment> updateAppointment(@Valid @RequestBody Appointment appointment) throws Exception
	{
		Appointment s1= appointmentService.updateAppointment(appointment);
		ResponseEntity<Appointment> re=new ResponseEntity<Appointment>(s1,HttpStatus.OK);
		return re;	
	}
	
/************************************************************************************************
	* Method Type        : GetMapping
	* Url path           : /getAppointmentstatus
	* Method Name        : getAppointmentstatus
	* Description        : To get All the Existing Appointments from the Database by their Status	                    
************************************************************************************************/	
	@GetMapping(path="/getAppointmentstatus")
	public ResponseEntity<List<Appointment>> getAppointmentstatus(@RequestBody String status)
	{
		List<Appointment> l=appointmentService.getAppointmentstatus(status);	
		ResponseEntity<List<Appointment>> re=new ResponseEntity<List<Appointment>>(l,HttpStatus.OK);
		return re;
	}
	
}
