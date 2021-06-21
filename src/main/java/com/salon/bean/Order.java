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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "Orders")
public class Order 
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long orderId;
	
	@NotNull
	private double orderAmount;
	
	@NotNull
	@Pattern(regexp="^\\d{2}-\\d{2}-\\d{4}$",message="Provide Date in the format DD-MM-YYYY")
	private String orderbillingDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="payment_id")
	private Payment payment;
	
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public double getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}
	public String getOrderbillingDate() {
		return orderbillingDate;
	}
	public void setOrderbillingDate(String orderbillingDate) {
		this.orderbillingDate = orderbillingDate;
	}
	
	
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderAmount=" + orderAmount + ", orderbillingDate=" + orderbillingDate
				+ ", payment=" + payment + "]";
	}
	
}
