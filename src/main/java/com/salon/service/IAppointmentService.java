/*********************************************************************************************
 * Description    : It is the Appointment Interface that contains various methods of 
                    Appointment Module
 *********************************************************************************************/
package com.salon.service;

import java.util.List;
import java.util.Optional;

import com.salon.bean.Appointment;

public interface IAppointmentService 
{
	public Appointment addAppointment(Appointment appointment);
	public List<Appointment> getAllAppointments();
	public List<Appointment> getAppointmentstatus(String status);
	public String removeAppointment(Long id);
	public Appointment updateAppointment(Appointment e) throws Exception;
	public Optional<Appointment> getAppointment(Long id);
}
