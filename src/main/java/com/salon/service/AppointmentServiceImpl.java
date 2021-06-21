/*********************************************************************************************
* Description   : It is a Appointment Service Implementation class that defines/overrides
                   the methods mentioned in its Interface (Service Interface).
  
***********************************************************************************************/
package com.salon.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.salon.bean.Appointment;
import com.salon.dao.IAppointmentRepository;

@Service
public class AppointmentServiceImpl implements IAppointmentService
{
	@Autowired
	IAppointmentRepository arepos;
/************************************************************************************************
	* Method             : addAppointment
	* Description        : To add the Appointment details		                    
************************************************************************************************/	
	@Override
	public Appointment addAppointment(Appointment appointment) 
	{
		Appointment a1= arepos.save(appointment);
		return a1;
	}
/*************************************************************************************************
	* Method              : removeAppointment
	* Description         : To remove the Appointment details
**************************************************************************************************/
	@Override
	public String removeAppointment(Long id) 
	{
		arepos.deleteById(id);
		return "Deleted Successfully";
	}
/*************************************************************************************************
	* Method              : updateAppointment
	* Description         : To remove the Appointment details
**************************************************************************************************/
	@Override
	public Appointment updateAppointment(Appointment a) throws Exception
	{
		long id=a.getAppointmentId();
		Supplier<Exception> s1=()-> new ResourceNotFoundException("Appointment id not found");
		
		Appointment a1=arepos.findById(id).orElseThrow(s1);
	
		a1.setLocation(a.getLocation());
		a1.setVisitType(a.getVisitType());
		a1.setPreferredService(a.getPreferredService());
		a1.setPreferredDate(a.getPreferredDate());
		a1.setPreferredTime(a.getPreferredTime());
		a1.setPayment(a.getPayment());
		a1.setSalonservice(a.getSalonservice());
		a1.setStatus(a.getStatus());
		arepos.save(a1);
		return a1;
	}
/************************************************************************************************
	* Method                      : getAppointment
	* Description                 : To display the AppointmentDetails by Id (Primary key)
			         
****************************************************************************************************/
	@Override
	public Optional<Appointment> getAppointment( Long id)
	{
		Optional<Appointment> a1=arepos.findById(id);
		return a1;
	}
/*************************************************************************************************
	* Method                       : getAllAppointments
	* Description                  : To display all the AppointmentDetails					
**************************************************************************************************/	
	@Override
	public List<Appointment> getAllAppointments() 
	{
		List<Appointment> l1=new ArrayList<>();
		l1=arepos.findAll();
		return l1;
	}
/***********************************************************************************************
	* Method                       : getAppointmentstatus
	* Description                  : To display the  Status of Appointment					
************************************************************************************************/
	@Override
	public List<Appointment> getAppointmentstatus(String status) 
	{
		return arepos.getAppointmentstatus(status);
	}
}
