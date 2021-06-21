/*************************************************************************************************
* Description   : It is a Customer Service Implementation class that defines/overrides
                   the methods mentioned in its Interface (Customer Interface).
**************************************************************************************************/
package com.salon.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.salon.bean.Customer;
import com.salon.dao.ICustomerRepository;

@Service
public class CustomerServiceImpl implements ICustomerService 
{
		@Autowired
		ICustomerRepository crepo;
		
		List<Customer> le;
/************************************************************************************************
	* Method             : addCustomer
	* Description        : To add the new Customer into the Database	                    
************************************************************************************************/	
		@Override
		public Customer addCustomer(Customer customer) 
		{
			Customer c1 = crepo.save(customer);
			return c1;
		}
/************************************************************************************************
	* Method             : removeCustomer
	* Description        : To remove Customer from the Database	                    
************************************************************************************************/	
		@Override
		public String removeCustomer(long userId) throws Exception 
		{
			Supplier<Exception> s1 = ()->new ResourceNotFoundException(" id is not present in the database");
			crepo.findById(userId).orElseThrow(s1);
			crepo.deleteById(userId);
			return "Deleted";
		}
/************************************************************************************************
	* Method             : getCustomer
	* Description        : To get the Customer Detail by the ID from the Database	                    
************************************************************************************************/		
		@Override
		public Customer getCustomer(long userId) throws Exception 
		{
			Supplier<Exception> s1 = ()->new ResourceNotFoundException(" id is not present in the database");
			Customer c1=crepo.findById(userId).orElseThrow(s1);
			return c1;	
		}
/************************************************************************************************
	* Method             : updateCustomer
	* Description        : To update the Customer Detail by using the ID 	                    
************************************************************************************************/		
		@Override
		public Customer updateCustomer(Customer c) throws Exception  
		{
			long id=c.getUserId();
			
			Supplier<Exception> s1 = ()->new ResourceNotFoundException(" id is not present in the database");
			Customer c1=crepo.findById(id).orElseThrow(s1);
			
			c1.setName(c.getName());
			c1.setContactNo(c.getContactNo());
			c1.setDob(c.getDob());
			c1.setEmail(c.getEmail());
			c1.setAddress(c.getAddress());	
			c1.setAppointment(c.getAppointment());
			c1.setOrder(c.getOrder());
			crepo.save(c1);
			return c1;	
		}
/************************************************************************************************
	* Method             : getAllCustomers
	* Description        : To get the All Customer Details in  the list form from the Database	                    
************************************************************************************************/		
		@Override
		public List<Customer> getAllCustomers()
		{
			le=new ArrayList<>();
			le=crepo.findAll();
			return le;
		}
/************************************************************************************************
	* Method          : getByCity
	* Description     : To get the All Customers belongs to a  City in  the list form from the Database	                    
************************************************************************************************/		
		@Override
		public List<Customer> getByCity(String city)
		{
			return crepo.findByCity(city);
		}		
}


