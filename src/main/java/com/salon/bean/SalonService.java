/*********************************************************************************************
 * Description    : It is an entity class that has various data members
 *********************************************************************************************/
package com.salon.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class SalonService {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long serviceId;
	@NotNull
	private String serviceName;
	@NotNull
	private double servicePrice;
	@NotNull
	private String serviceDuration;
	@NotNull
	private int discount;
	public long getServiceId() {
		return serviceId;
	}
	public void setServiceId(long serviceId) {
		this.serviceId = serviceId;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public double getServicePrice() {
		return servicePrice;
	}
	public void setServicePrice(double servicePrice) {
		this.servicePrice = servicePrice;
	}
	public String getServiceDuration() {
		return serviceDuration;
	}
	public void setServiceDuration(String serviceDuration) {
		this.serviceDuration = serviceDuration;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	@Override
	public String toString() {
		return "SalonService [serviceId=" + serviceId + ", serviceName=" + serviceName + ", servicePrice="
				+ servicePrice + ", serviceDuration=" + serviceDuration + ", discount=" + discount + "]";
	}
	
}
