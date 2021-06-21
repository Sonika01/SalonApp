/*********************************************************************************************
 * Description    : It is the Payment Interface that contains various methods of 
                    Payment Module
 *********************************************************************************************/
package com.salon.service;

import java.util.List;

import com.salon.bean.Payment;

public interface IPaymentService 
{
	public Payment addPayment(Payment payment);
	public String removePayment(long id)throws Exception;
	public Payment updatePayment(Payment payment)throws Exception;
	public Payment getPaymentDetails(long id) throws Exception;
	public List<Payment> getAllPaymentDetails();

}
