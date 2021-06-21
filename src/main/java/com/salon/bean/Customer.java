/*********************************************************************************************
 * Description    : It is an entity class that has various data members
 *********************************************************************************************/

package com.salon.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Customer 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long userId;
	
	@NotNull
	@Size(min=3,message="User name should atleast 3 characters")
	@Column(name="User_name")
	private String name;
	
	@NotNull
	@Column(name="email")
	private String email;
	
	@NotNull
	@Size(min=10,max=10,message="Please provide valid mobile no.")
	private String contactNo;
	
	@NotNull
	@Pattern(regexp="^\\d{2}-\\d{2}-\\d{4}$",message="Provide Date in the format DD-MM-YYYY")
	private String dob;
	
	@NotNull
	@OneToOne(cascade=CascadeType.ALL)
	private Address address;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="appointment_id")
	private Appointment appointment;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="order_id")
	private Order order;
	
	public Customer() {
		
	}

	public Customer(long userId, @NotNull @Size(min = 3, message = "User name should atleast 3 characters") String name,
			@NotNull String email,
			@NotNull @Size(min = 10, max = 10, message = "Please provide valid mobile no.") String contactNo,
			@NotNull @Pattern(regexp = "^\\d{2}-\\d{2}-\\d{4}$", message = "Provide Date in the format DD-MM-YYYY") String dob,
			@NotNull Address address, Appointment appointment, Order order) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.dob = dob;
		this.address = address;
		this.appointment = appointment;
		this.order = order;
	}


	public long getUserId() {
		return userId;
	}

	public void setUserId(long l) {
		this.userId = l;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}



	@Override
	public String toString() {
		return "Customer [userId=" + userId + ", name=" + name + ", email=" + email + ", contactNo=" + contactNo
				+ ", dob=" + dob + ", address=" + address + ", appointment=" + appointment + ", order=" + order + "]";
	}

}
