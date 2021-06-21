/*********************************************************************************************     
 * Description :  ICustomerRepository is an interface which extends JPA repository.
            	  This class belongs to DAO layer. It is used to perform CRUD operations
            	  with our entities by defining JPA repositories for automatic 
            	  and intelligent implementations.   
            	  
  * @Query     : @Query annotation in Spring Data JPA to execute both JPQL and native SQL queries.

 ************************************************************************************************/

package com.salon.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salon.bean.Customer;

public interface ICustomerRepository extends JpaRepository<Customer,Long>
{
	@Query("select c from Customer c where c.address.aId in (select a.aId from Address a where a.city=?1)")
	List<Customer>findByCity(String city);

}
