/*************************************************************************************************
* Description   : It is a User Service Implementation class that defines/overrides
                   the methods mentioned in its Interface (User Interface).
**************************************************************************************************/
package com.salon.service;

import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.salon.bean.Customer;
import com.salon.bean.User;
import com.salon.dao.IUserRepository;

@Service
public class UserServiceImpl implements IUserService 
{
	
	@Autowired
	IUserRepository userrepository;
/************************************************************************************************
	* Method             : createUser
	* Description        : To create the new user to the database.
	* Input Parameters   : User Details(User, Password, Role)         
************************************************************************************************/
	@Override
	public User createUser(User u)
	{
		User u1=userrepository.save(u);
		return u1;
	}
/************************************************************************************************
	* Method             : SignIn
	* Description        : To Get the access into the Database. 
	                       The Customer/Admin has to SignIn to the Application First. 
	                       So They Need to Enter Their Specific UserId and Password.
	                       
(Before that,They Must Enter all their Details into the Database and get their UserId & Password)              
************************************************************************************************/
	@Override
	public Customer signIn(Long userId,String password)throws Exception 
	{
	   Supplier<Exception> s1 = ()->new ResourceNotFoundException("Invalid id & Password for SignIn");
	   Supplier<Exception> s2 = ()->new ResourceNotFoundException("The Entered UserId is Not Registered in Databse");
	   User u1=((Optional<User>) userrepository.SignIn(userId,password)).orElseThrow(s1);
	   Customer u2=((Optional<Customer>) userrepository.customer(userId)).orElseThrow(s2);
	   return u2;
	}
/************************************************************************************************
	* Method             : ChangeUserPassword
	* Description        : To change the User Password.
	* Input Parameters   : UserId, Password, New Password           
************************************************************************************************/	
	@Override
	public User ChangeUserpassword(Long userId,String password,String newpassword) throws Exception  
	{
		    String np=newpassword;
		    Supplier<Exception> s1 = ()->new ResourceNotFoundException("Provided Id and Password is not Valid");
		    User u1=((Optional<User>) userrepository.Changepassword(userId,password)).orElseThrow(s1);
		
		    u1.setPassword(np);
			userrepository.save(u1);
			return u1;	
	}
/************************************************************************************************
	* Method             : SignOut
	* Description        : To Disable the access from the database.
	* Input Parameters   : UserId         
************************************************************************************************/
	@Override
	public User SignOut(Long userId) throws Exception 
	{
	   Supplier<Exception> s1 = ()->new ResourceNotFoundException("Invalid id for SignOut");
	   User u1=((Optional<User>) userrepository.SignOut(userId)).orElseThrow(s1);
	   return u1;
	}
}
