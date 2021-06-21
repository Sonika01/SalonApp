/*********************************************************************************************     
 * Description :  SalonServiceImplTest is a class which test all the methods present 
                  inside the Salon Service by using TDD approach.
            	  This class belongs to Test layer.                      					  

 * @SpringBootTest    : It can be specified on a test class that runs Spring Boot based tests.
 ************************************************************************************************/
package com.salon.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.assertj.core.api.Assertions.assertThat;

import com.salon.bean.SalonService;
import com.salon.dao.ISalonRepository;

@SpringBootTest
class SalonServiceImplTest 
{

	@Autowired
	ISalonService isalonservice;
	@MockBean
	ISalonRepository srepo;
/*********************************************************************************************     
	Test Case Name  :  TC_23
	Description     :  This method uses The Mockito Concept to test the AddService method
						            in service class.
************************************************************************************************/	
	@Test
	void testAddService() {
		SalonService salonService=new SalonService();
		salonService.setServiceId(1);
		salonService.setServiceName("Hair Cut");
		salonService.setServicePrice(100);
		salonService.setServiceDuration("10 minutes");
		salonService.setDiscount(20);
		Mockito.when(srepo.save(salonService)).thenReturn(salonService);	
		SalonService response=isalonservice.addService(salonService);
		assertThat(response.getServiceId()).isEqualTo(1);
		assertThat(response.getServiceName()).isEqualTo("Hair Cut");
		assertThat(response.getServicePrice()).isEqualTo(100);
		assertThat(response.getServiceDuration()).isEqualTo("10 minutes");
		assertThat(response.getDiscount()).isEqualTo(20);
			}
/*********************************************************************************************     
	Test Case Name  :  STC_24
	Description     :  This method uses The Mockito Concept to test the RemoveService method
						            in service class.
************************************************************************************************/
	@Test
	void testRemoveService() throws Exception {
		SalonService s1=new SalonService();
		s1.setServiceId(1);
		s1.setServiceName("Hair Cut");
		s1.setServicePrice(100);
		s1.setServiceDuration("10 minutes");
		s1.setDiscount(20);
		Optional<SalonService> s2=Optional.of(s1);
		Mockito.when(srepo.findById((long) 1)).thenReturn(s2);
		Mockito.when(srepo.existsById(s1.getServiceId())).thenReturn(false);
		assertFalse(srepo.existsById(s1.getServiceId()));	
	}

/*********************************************************************************************     
	Test Case Name  :  STC_25
	Description     :  This method uses The Mockito Concept to test the UpdateService method
						            in service class.
************************************************************************************************/	
	@Test
	void testUpdateService() throws Exception 
	{
		SalonService s1=new SalonService();
		s1.setServiceId(1);
		s1.setServiceName("Hair Cut");
		s1.setServicePrice(100);
		s1.setServiceDuration("10 minutes");
		s1.setDiscount(20);
		Optional<SalonService> s2=Optional.of(s1);
		Mockito.when(srepo.findById((long) 1)).thenReturn(s2);
		s1.setServiceName("Hair dying");
		Mockito.when(srepo.save(s1)).thenReturn(s1);
		assertThat(isalonservice.updateService(s1)).isEqualTo(s1);	
	}
/*********************************************************************************************     
	Test Case Name  :  STC_26
	Description     :  This method uses The Mockito Concept to test the GetService method
						            in service class.
************************************************************************************************/
	@Test
	void testGetService() throws Exception 
	{
		SalonService s1=new SalonService();
		s1.setServiceId(1);
		s1.setServiceName("Hair Cut");
		s1.setServicePrice(100);
		s1.setServiceDuration("10 minutes");
		s1.setDiscount(20);
		Optional<SalonService> s2=Optional.of(s1);
		Mockito.when(srepo.findById((long) 1)).thenReturn(s2);
		Optional<SalonService> s3=Optional.of(isalonservice.getService(1));
		assertThat(s3).isEqualTo(s2);	
		
	}
	
/*********************************************************************************************     
	Test Case Name  :  STC_27
	Description     :  This method uses The Mockito Concept to test the GetAllServices method
						            in service class.
************************************************************************************************/
       @Test
		void testGetAllServices() 
       {
		SalonService s1=new SalonService();
		s1.setServiceId(1);
		s1.setServiceName("Hair Cut");
		s1.setServicePrice(100);
		s1.setServiceDuration("10 minutes");
		s1.setDiscount(20);
		List<SalonService> ls=new ArrayList<>();
		ls.add(s1);
		Mockito.when(srepo.findAll()).thenReturn(ls);
		assertThat(isalonservice.getAllServices()).isEqualTo(ls);		
	}
       
/*********************************************************************************************     
   	Test Case Name  :  STC_28
   	Description     :  This method uses The Mockito Concept to test the GetServiceByName method
   						            in service class.
************************************************************************************************/
	@Test
	void testGetServiceByName() 
	{
		SalonService s1=new SalonService();
		s1.setServiceId(1);
		s1.setServiceName("Hair Cut");
		s1.setServicePrice(100);
		s1.setServiceDuration("10 minutes");
		s1.setDiscount(20);
		List<SalonService> ls=new ArrayList<>();
		ls.add(s1);
		Mockito.when(srepo.findByServiceName((String)"Hair Cut")).thenReturn(ls);
		assertThat(isalonservice.getServiceByName("Hair Cut")).isEqualTo(ls);
	}
	
/*********************************************************************************************     
	Test Case Name  :  STC_29
	Description     :  This method uses The Mockito Concept to test the GetServiceByPrice method
						            in service class.
************************************************************************************************/
	@Test
	void testGetServiceByPrice() 
	{
		SalonService s1=new SalonService();
		s1.setServiceId(1);
		s1.setServiceName("Hair Cut");
		s1.setServicePrice(100);
		s1.setServiceDuration("10 minutes");
		s1.setDiscount(20);
		List<SalonService> ls=new ArrayList<>();
		ls.add(s1);
		Mockito.when(srepo.findByServicePrice((double)100)).thenReturn(ls);
		assertThat(isalonservice.getServiceByPrice(100)).isEqualTo(ls);	
	}
/*********************************************************************************************     
	Test Case Name  :  STC_30
	Description     :  This method uses The Mockito Concept to test the GetServiceByDuration method
						            in service class.
************************************************************************************************/	
	@Test
	void testGetServiceByDuration() {
		SalonService s1=new SalonService();
		s1.setServiceId(1);
		s1.setServiceName("Hair Cut");
		s1.setServicePrice(100);
		s1.setServiceDuration("30 minutes");
		s1.setDiscount(20);
		List<SalonService> ls=new ArrayList<>();
		ls.add(s1);
		Mockito.when(srepo.findByServiceDuration((String)"30 minutes")).thenReturn(ls);
		assertThat(isalonservice.getServiceDuration("30 minutes")).isEqualTo(ls);	
	}

}
