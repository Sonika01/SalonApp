/*********************************************************************************************
 * Description    : It is the Customer Interface that contains various methods of 
                    Customer Module
 *********************************************************************************************/
package com.salon.service;

import java.util.List;

import com.salon.bean.Customer;

public interface ICustomerService {
	
	public Customer addCustomer(Customer customer);
	public String removeCustomer(long custId) throws Exception ;
	public Customer updateCustomer(Customer c) throws Exception;
	public Customer getCustomer(long custId) throws Exception;
	public List<Customer> getAllCustomers(); 
	public List<Customer> getByCity(String city);
}
