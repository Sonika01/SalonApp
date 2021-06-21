/*********************************************************************************************     
 * Description :  IOrderRepository is an interface which extends JPA repository.
            	  This class belongs to DAO layer. It is used to perform CRUD operations
            	  with our entities by defining JPA repositories for automatic 
            	  and intelligent implementations.                     					  

 ************************************************************************************************/

package com.salon.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salon.bean.Order;


public interface IOrderRepository extends JpaRepository<Order,Long>
{
	

}
