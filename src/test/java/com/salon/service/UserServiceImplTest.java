/*********************************************************************************************     
 * Description :  UserServiceImplTest is a class which test all the methods present 
                  inside the User Service by using TDD approach.
            	  This class belongs to Test layer.                      					  

 * @SpringBootTest    : It can be specified on a test class that runs Spring Boot based tests.
 ************************************************************************************************/
package com.salon.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.salon.bean.Address;
import com.salon.bean.Customer;
import com.salon.bean.User;
import com.salon.dao.IUserRepository;


@SpringBootTest
class UserServiceImplTest 
{
	@Autowired
	IUserService userservice;
	
	@MockBean
	IUserRepository userrepository;
/*********************************************************************************************     
	Test Case Name  :  UTC_31
	Description     :  This method uses The Mockito Concept to test the createUser method
						            in service class.
************************************************************************************************/	
	@Test
	void testcreateUser()
	{
		User user1 = new User();
		user1.setUserId(1L);
		user1.setRole("Admin");
		user1.setPassword("Venkat@123");
		
		Mockito.when(userrepository.save(user1)).thenReturn(user1);
		
		User response=userservice.createUser(user1);
		
		assertThat(response.getUserId()).isEqualTo(1L);
		assertThat(response.getPassword()).isEqualTo("Venkat@123");
		assertThat(response.getRole()).isEqualTo("Admin");
	}
	
/*********************************************************************************************     
	Test Case Name  :  UTC_32
	Description     :  This method uses The Mockito Concept to test the ChangeUserpassword method
						            in service class.
************************************************************************************************/	
	@Test
	void testChangeUserpassword() throws Exception 
	{
		User user1 = new User();
		user1.setUserId(1L);
		user1.setPassword("Venkat@123");
		user1.setRole("Admin");
		
		Optional<User> user2=Optional.of(user1);
		
		Mockito.when(userrepository.Changepassword( 1L, "Venkat@123" )).thenReturn(user2);
		user1.setPassword("Ven@5555");
		Mockito.when(userrepository.save(user1)).thenReturn(user1);	
		assertThat(userservice.ChangeUserpassword(1L,"Venkat@123","Ven@555")).isEqualTo(user1);	
	}	
	
/*********************************************************************************************     
	Test Case Name  :  UTC_34
	Description     :  This method uses The Mockito Concept to test the SignOut method
						            in service class.
************************************************************************************************/	
	@Test
	void testSignOut() throws Exception 
	{
		User user1 = new User();
		user1.setUserId(1L);
		user1.setPassword("Rakesh@123");
		user1.setRole("Customer");
		Optional<User> u2 = Optional.of(user1);
		Mockito.when(userrepository.SignOut(1L)).thenReturn(u2);
		Optional<User> u3 = Optional.of(userservice.SignOut(1L));
		assertThat(u3).isEqualTo(u2);	
		
	}
	
/*********************************************************************************************     
	Test Case Name  :  UTC_35
	Description     :  This method uses The Mockito Concept to test the SignIn method
						            in service class.
************************************************************************************************/	
	@Test 
	void testSignIn() throws Exception 
	{
		User u1 = new User();
		u1.setUserId(1L);
		u1.setPassword("Rakesh@123");
		u1.setRole("Customer");
		Optional<User> u2 = Optional.of(u1);
		
		Address a = new Address();
		a.setDoorNo("14");
		a.setStreet("Third Street");
		a.setArea("Gandhi Nager");
		a.setCity("Dolakpur");
		a.setState("Pondicherry");
		
		Customer c = new Customer();
		c.setUserId(1L);
		c.setName("Rakesh");
		c.setContactNo("1234567899");
		c.setDob("15-11-2020");
		c.setEmail("Rakesh123@gmail.com");
		c.setAddress(a);
		Optional<Customer> c2 = Optional.of(c);
		
		Mockito.when(userrepository.SignIn(1L,"Rakesh@123")).thenReturn(u2);
		Mockito.when(userrepository.customer(1L)).thenReturn(c2);
		Optional<Customer> c3=Optional.of(userservice.signIn(1L,"Rakesh@123"));	
		assertThat(c3).isEqualTo(c2);
	}
}
