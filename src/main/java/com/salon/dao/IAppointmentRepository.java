/*********************************************************************************************     
 * Description :  IAppointmentRepository is an interface which extends JPA repository.
            	  This class belongs to DAO layer. It is used to perform CRUD operations
            	  with our entities by defining JPA repositories for automatic 
            	  and intelligent implementations.                     					  

 * @Query     : @Query annotation in Spring Data JPA to execute both JPQL and native SQL queries.
 ************************************************************************************************/
package com.salon.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.salon.bean.Appointment;

@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment,Long>{
	
	@Query(value="select * from appointment where status=:status",nativeQuery=true)
	List<Appointment> getAppointmentstatus(@Param("status") String status);

}
