/*********************************************************************************************     
 * Description :  ISalonRepository is an interface which extends JPA repository.
            	  This class belongs to DAO layer. It is used to perform CRUD operations
            	  with our entities by defining JPA repositories for automatic 
            	  and intelligent implementations. 
   
  * @Query     : @Query annotation in Spring Data JPA to execute both JPQL and native SQL queries.                   					  

 ************************************************************************************************/
package com.salon.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.salon.bean.Customer;
import com.salon.bean.User;

@Repository
public interface IUserRepository extends JpaRepository<User,Long>{
	@Query("Select u from User u where u.userId=?1 and u.password=?2")
	Optional<User> SignIn(Long userId,String password);
	
	@Query("Select c from Customer c Where c.userId=?1")
	Optional<Customer> customer(Long userId);
	
	@Query("Select u from User u where u.userId=?1")
	Optional<User> SignOut(Long userId);
	
	@Query("Select u from User u where u.userId=?1 and u.password=?2")
	Optional<User> Changepassword(Long userId,String password);

}
