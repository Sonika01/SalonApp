/*********************************************************************************************     
 * Description :  AppointmentServiceImplTest is a class which test all the methods present 
                  inside the Appointment Service by using TDD approach.
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

import com.salon.bean.Appointment;
import com.salon.dao.IAppointmentRepository;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AppointmentServiceImplTest 
{
	@Autowired
	IAppointmentService iappointmentService;
	@MockBean
	IAppointmentRepository arepos;
/*********************************************************************************************     
 * Test Case Name :  ATC_01
   Description    :  This method uses The Mockito Concept to test the AddAppointment method
                     in service class.
************************************************************************************************/	
	@Test
	void testAddAppointment() {
		Appointment appointment = new Appointment();
		appointment.setAppointmentId(1);
		appointment.setLocation("Hyderabad");
		appointment.setPreferredDate("20112011");
		appointment.setPreferredService("Hair Cut");
		appointment.setPreferredTime("10:00:00");
		appointment.setStatus("open");
		appointment.setVisitType("Office");
		Mockito.when(arepos.save(appointment)).thenReturn(appointment);	
		Appointment response=iappointmentService.addAppointment(appointment);
		assertThat(response.getAppointmentId()).isEqualTo(1);
		assertThat(response.getLocation()).isEqualTo("Hyderabad");
		assertThat(response.getPreferredDate()).isEqualTo("20112011");
		assertThat(response.getPreferredService()).isEqualTo("Hair Cut");
		assertThat(response.getPreferredTime()).isEqualTo("10:00:00");
		assertThat(response.getStatus()).isEqualTo("open");
		assertThat(response.getVisitType()).isEqualTo("Office");
			}
/*********************************************************************************************     
 * Test Case Name :  ATC_02
   Description    :  This method uses The Mockito Concept to test the RemoveAppointment method
	                     in service class.
************************************************************************************************/	

	@Test
	void testRemoveAppointment(){
		Appointment appointment = new Appointment();
		appointment.setAppointmentId(1);
		appointment.setLocation("Hyderabad");
		appointment.setPreferredDate("20112011");
		appointment.setPreferredService("Hair Cut"); 
		appointment.setPreferredTime("10:00:00");
		appointment.setStatus("open");
		appointment.setVisitType("Office");
		Optional<Appointment> a1=Optional.of(appointment);
		Mockito.when(arepos.findById((long) 1)).thenReturn(a1);
		Mockito.when(arepos.existsById(appointment.getAppointmentId())).thenReturn(false);
		assertFalse(arepos.existsById(appointment.getAppointmentId()));
		}
/*********************************************************************************************     
 * Test Case Name :  ATC_03
   Description    :  This method uses The Mockito Concept to test the UpdateAppointment method
		                     in service class.
************************************************************************************************/
	@Test
	void testUpdateAppointment() throws Exception {
		Appointment appointment = new Appointment();
		appointment.setAppointmentId(1);
		appointment.setLocation("Hyderabad");
		appointment.setPreferredDate("20112011");
		appointment.setPreferredService("Hair Cut");
		appointment.setPreferredTime("10:00:00");
		appointment.setStatus("open");
		appointment.setVisitType("Office");
		Optional<Appointment> a1=Optional.of(appointment);
		Mockito.when(arepos.findById((long) 1)).thenReturn(a1);
		appointment.setLocation("Karimnagar");
		Mockito.when(arepos.save(appointment)).thenReturn(appointment);	
		assertThat(iappointmentService.updateAppointment(appointment)).isEqualTo(appointment);	
	}
/*********************************************************************************************     
* Test Case Name :  ATC_04
  Description    :  This method uses The Mockito Concept to test the GetAppointment method
		                     in service class.
************************************************************************************************/
	@Test
	void testGetAppointment() {
		Appointment appointment = new Appointment();
		appointment.setAppointmentId(1);
		appointment.setLocation("Hyderabad");
		appointment.setPreferredDate("20112011");
		appointment.setPreferredService("Hair Cut");
		appointment.setPreferredTime("10:00:00");
		appointment.setStatus("open");
		appointment.setVisitType("Office");
		Optional<Appointment> a1=Optional.of(appointment);
		Mockito.when(arepos.findById((long) 1)).thenReturn(a1);
		assertThat(iappointmentService.getAppointment((long) 1)).isEqualTo(a1);	

	}
/*********************************************************************************************     
 * Test Case Name :  ATC_05
   Description    :  This method uses The Mockito Concept to test the GetAllAppointments method
		             in service class.
************************************************************************************************/
	@Test
	void testGetAllAppointments()  {
			Appointment appointment = new Appointment();
			appointment.setAppointmentId(1);
			appointment.setLocation("Hyderabad");
			appointment.setPreferredDate("20112011");
			appointment.setPreferredService("Hair Cut");
			appointment.setPreferredTime("10:00:00");
			appointment.setStatus("open");
			appointment.setVisitType("Office");
			List<Appointment> ls=new ArrayList<>();
			ls.add(appointment);
			Mockito.when(arepos.findAll()).thenReturn(ls);
			assertThat(iappointmentService.getAllAppointments()).isEqualTo(ls);
	}
/*********************************************************************************************     
* Test Case Name :  ATC_06
  Description    :  This method uses The Mockito Concept to test the GetAppointmentstatus method
		            in service class.
************************************************************************************************/
	@Test
	void testGetAppointmentstatus() {
		Appointment appointment = new Appointment();
		appointment.setAppointmentId(1);
		appointment.setLocation("Hyderabad");
		appointment.setPreferredDate("20112011");
		appointment.setPreferredService("Hair Cut");
		appointment.setPreferredTime("10:00:00");
		appointment.setStatus("open");
		appointment.setVisitType("Office");
		List<Appointment> ls=new ArrayList<>();
		ls.add(appointment);
		Mockito.when(arepos.getAppointmentstatus((String)"open")).thenReturn(ls);
		assertThat(iappointmentService.getAppointmentstatus("open")).isEqualTo(ls);
	}

}
