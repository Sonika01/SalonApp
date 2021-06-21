/*********************************************************************************************     
 * Description :  CustomerServiceImplTest is a class which test all the methods present 
                  inside the Customer Service by using TDD approach.
            	  This class belongs to Test layer.                      					  

 * @SpringBootTest    : It can be specified on a test class that runs Spring Boot based tests.
 ************************************************************************************************/
package com.salon.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.salon.bean.Address;
import com.salon.bean.Customer;
import com.salon.dao.ICustomerRepository;


@SpringBootTest
class CustomerServiceImplTest 
{
	@Autowired
	ICustomerService icustomerservice;
	
	@MockBean
	ICustomerRepository crepo;
/*********************************************************************************************     
* Test Case Name :  CTC_07
  Description    :  This method uses The Mockito Concept to test the GetAddCustomer method
			            in service class.
************************************************************************************************/
	@Test
	void testAddCustomer() 
	{
		Address address = new Address();
		address.setArea("Karimnagar");
		
		Customer customer = new Customer();
		customer.setUserId(1);
		customer.setName("Raviteja");
		customer.setEmail("Raviteja092.rt@gmail.com");
		customer.setDob("04-08-1998");
		customer.setAddress(address);
		
		Mockito.when(crepo.save(customer)).thenReturn(customer);
		Customer response = icustomerservice.addCustomer(customer);
		assertThat(response.getUserId()).isEqualTo(customer.getUserId());
		assertThat(response.getName()).isEqualTo(customer.getName());
		assertThat(response.getAddress().getArea()).isEqualTo(address.getArea());	
	}
	
/*********************************************************************************************     
* Test Case Name :  CTC_08
  Description    :  This method uses The Mockito Concept to test the RemoveCustomer method
			            in service class.
************************************************************************************************/
	@Test
	void testRemoveCustomer() throws Exception 
	{
		Customer c1 = new Customer();
		c1.setUserId(1);
		c1.setName("ravi");
		c1.setEmail("Ravi@gmail.com");
		Optional<Customer> c2 = Optional.of(c1);
		Mockito.when(crepo.findById((long)1)).thenReturn(c2);
		Mockito.when(crepo.existsById(c1.getUserId())).thenReturn(false);
		assertFalse(crepo.existsById(c1.getUserId()));	
	}
	
/*********************************************************************************************     
* Test Case Name :  CTC_09
  Description    :  This method uses The Mockito Concept to test the GetCustomer method
			            in service class.
************************************************************************************************/
	@Test
	void testGetCustomer() throws Exception 
	{
		Customer c1 = new Customer();
		c1.setUserId(1);
		c1.setName("ravi");
		c1.setEmail("Ravi@gmail.com");
		Optional<Customer> c2 = Optional.of(c1);
		Mockito.when(crepo.findById((long)1)).thenReturn(c2);
		Optional<Customer> c3 = Optional.of(icustomerservice.getCustomer(1));
		assertThat(c3).isEqualTo(c2);	
	}
	
/*********************************************************************************************     
* Test Case Name :  CTC_10
  Description    :  This method uses The Mockito Concept to test the UpdateCustomer method
			            in service class.
************************************************************************************************/
	@Test
	void testUpdateCustomer() throws Exception 
	{
		Customer c1=new Customer();
		c1.setUserId(1);
		c1.setName("ravi");
		c1.setEmail("a@gmail.com");
		Optional<Customer> c2=Optional.of(c1);
		Mockito.when(crepo.findById((long) 1)).thenReturn(c2);
		c1.setName("raviteja");
		Mockito.when(crepo.save(c1)).thenReturn(c1);
		assertThat(icustomerservice.updateCustomer(c1)).isEqualTo(c1);
	}
	
/*********************************************************************************************     
* Test Case Name :  CTC_11
  Description    :  This method uses The Mockito Concept to test the GetAllCustomers method
			            in service class.
************************************************************************************************/
	@Test
	void testGetAllCustomers() 
	{
		Customer c1 = new Customer();
		c1.setUserId(1);
		c1.setName("Ravi");
		List<Customer> ls = new ArrayList<>();
		ls.add(c1);
		Mockito.when(crepo.findAll()).thenReturn(ls);
		assertThat(icustomerservice.getAllCustomers()).isEqualTo(ls);	
	}
	
/*********************************************************************************************     
Test Case Name  :  CTC_12
 Description    :  This method uses The Mockito Concept to test the GetByCity method
			            in service class.
************************************************************************************************/	
	@Test
	void testGetByCity() 
	{
		Address address = new Address();
		address.setCity("MUMBAI");
		Customer c1=new Customer();
		List<Customer> ls=new ArrayList<>();
		ls.add(c1);
		Mockito.when(crepo.findByCity((String)"MUMBAI")).thenReturn(ls);
		assertThat(icustomerservice.getByCity("MUMBAI")).isEqualTo(ls);	
	}	
}
