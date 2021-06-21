/*********************************************************************************************     
 Description : Its acts as the RestController For User Module
  
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

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salon.bean.Customer;
import com.salon.bean.User;
import com.salon.service.UserServiceImpl;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class UserController 
{
	@Autowired
	UserServiceImpl userservice;
	
/************************************************************************************************
		* Method Type        : PostMapping
		* Url path           : /addUser
		* Method Name        : addUser
		* Description        : To add the new User detail to the Database		                    
************************************************************************************************/		
	@PostMapping(path="/addUser")
	public ResponseEntity<User> addUser(@Valid @RequestBody User u)
	{
		User u1=userservice.createUser(u);
		ResponseEntity<User> re=new ResponseEntity<User>(u1,HttpStatus.OK);
		return re;
	}
	
/************************************************************************************************
		* Method Type        : GetMapping
		* Url path           : /SignIn/{userId}/{password}
		* Method Name        : Welcome_To_SALOON_Sign_In
		* Description        : To add the new User detail to the Database		                    
************************************************************************************************/		
	  @GetMapping("/SignIn/{userId}/{password}")
	  public ResponseEntity <Customer> Welcome_To_SALOON_Sign_In(@Valid @RequestBody Long userId,String password)throws Exception
	  {
	      Customer u1=userservice.signIn(userId,password);
		  ResponseEntity<Customer> re=new ResponseEntity<Customer>(u1,HttpStatus.OK);
		  return re;	
	  }

/************************************************************************************************
		* Method Type        : PutMapping
		* Url path           : /ChangePassword/{userId}/{password}/{newpassword}
		* Method Name        : Want_To-Change_Password
		* Description        : To change the new Password for User detail in the Database		                    
************************************************************************************************/		
	@PutMapping(path="/ChangePassword/{userId}/{password}/{newpassword}")
	public ResponseEntity<User> Want_To_Change_Password(@Valid @PathVariable Long userId,String password,String newpassword) throws Exception
	{
		User u1=userservice.ChangeUserpassword(userId,password,newpassword);
			
		ResponseEntity<User> re=new ResponseEntity<User>(u1,HttpStatus.OK);
		return re;
	}

/************************************************************************************************
		* Method Type        : GetMapping
		* Url path           : /SignOut/{userIdno}
		* Method Name        : Sign_Out
		* Description        : To Detach the access of the customer from the Database		                    
************************************************************************************************/		
	@GetMapping("/SignOut/{userIdno}")
	public ResponseEntity <String> Sign_Out(@RequestBody Long userId) throws Exception
	{
	    User u1= userservice.SignOut(userId);
	    String s="Logged Out Succssfully";
		ResponseEntity<String> re=new ResponseEntity<String>(s,HttpStatus.OK);
		return re;		
	}

}

