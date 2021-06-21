/*********************************************************************************************
 * Description    : It is an entity class that has various data members
 *********************************************************************************************/

package com.salon.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="Customer_Address")
public class Address
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long aId;
	
	@NotNull
	@Column(name="Door_No")
	private String doorNo;
	
	@Column(name="Street_Name")
	private String street;
	
	@Column(name="Area_Name")
	private String area;
	
	@NotNull
	@Column(name="City")
	private String city;
    
	@NotNull
	@Column(name="State")
	private String state;
	
	@NotNull
	@Column(name="Pincode")
	@Size(min=6,max=6)
	private String pincode;
	
	public Address() {
		
	}
	
	public Address(@NotNull String doorNo, String street, String area, @NotNull String city, @NotNull String state,
			@NotNull @Size(min = 6, max = 6) String pincode) {
		super();
		this.doorNo = doorNo;
		this.street = street;
		this.area = area;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}



	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getDoorNo() {
		return doorNo;
	}
	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Address [doorNo=" + doorNo + ", street=" + street + ", area=" + area + ", city=" + city + ", state="
				+ state + ", pincode=" + pincode + "]";
	}

	
	
}
