/*********************************************************************************************
 * Description    : It is an entity class that has various data members
 *********************************************************************************************/

package com.salon.bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Appointment 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long appointmentId;
	
	@NotNull
	private String location;
	
	@NotNull
	private String visitType;
	
	@NotNull
	private String preferredService;
	
	@NotNull
	@Pattern(regexp="^\\d{2}-\\d{2}-\\d{4}$",message="Provide Date in the format DD-MM-YYYY")
	private String preferredDate;
	
	@NotNull
	@Pattern(regexp="^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$", message="Time format should be HH:MM")
	private String preferredTime;
	
	@NotBlank
	@Pattern(regexp="OPEN|CLOSED", message="Status should be open or closed!!")
	private String status;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="payment_id")
	private Payment payment;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="salonservice_id")
	private SalonService salonservice;
	
	
	public long getAppointmentId() 
	{
		return appointmentId;
	}
	public void setAppointmentId(long appointmentId)
	{
		this.appointmentId = appointmentId;
	}
	public String getLocation() 
	{
		return location;
	}
	public void setLocation(String location) 
	{
		this.location = location;
	}
	public String getVisitType() 
	{
		return visitType;
	}
	public void setVisitType(String visitType) 
	{
		this.visitType = visitType;
	}
	public String getPreferredService()
	{
		return preferredService;
	}
	public void setPreferredService(String preferredService) 
	{
		this.preferredService = preferredService;
	}
	public String getPreferredDate() 
	{
		return preferredDate;
	}
	public void setPreferredDate(String preferredDate) 
	{
		this.preferredDate = preferredDate;
	}
	public String getPreferredTime() 
	{
		return preferredTime;
	}
	public void setPreferredTime(String preferredTime) 
	{
		this.preferredTime = preferredTime;
	}
	public String getStatus() 
	{
		return status;
	}
	public void setStatus(String status) 
	{
		this.status = status;
	}
	
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public SalonService getSalonservice() {
		return salonservice;
	}
	public void setSalonservice(SalonService salonservice) {
		this.salonservice = salonservice;
	}
	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", location=" + location + ", visitType=" + visitType
				+ ", preferredService=" + preferredService + ", preferredDate=" + preferredDate + ", preferredTime="
				+ preferredTime + ", status=" + status + ", payment=" + payment + ", salonservice=" + salonservice
				+ "]";
	}
	
}
