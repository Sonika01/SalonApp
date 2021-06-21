/*********************************************************************************************
* Description   : It is a Payment Service Implementation class that defines/overrides
                   the methods mentioned in its Interface (Payment Interface).
  
***********************************************************************************************/
package com.salon.service;
 

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.salon.bean.Payment;
import com.salon.dao.IPaymentRepository;

@Service
public class PaymentServiceImpl implements IPaymentService 
{
		@Autowired
		IPaymentRepository irepo;
/************************************************************************************************
	* Method             : addPayment
	* Description        : To add the new Payment detail to the Database		                    
************************************************************************************************/		
	@Override
	public Payment addPayment(Payment payment) 
	{
		payment =irepo.save(payment);
		return payment;
	}
/************************************************************************************************
	* Method             : removePayment
	* Description        : To remove the Payment detail from the Database		                    
************************************************************************************************/		
	@Override
	public String removePayment(long id)throws Exception 
	{
		Supplier<Exception> s=()->new ResourceNotFoundException("Payment Id is not present in the Database");
		irepo.findById(id).orElseThrow(s);
		irepo.deleteById(id);
		return "deleted";
	}
/************************************************************************************************
		* Method             : updatePayment
		* Description        : To update the Existing Payment detail by Id 		                    
************************************************************************************************/		
	@Override
	public Payment updatePayment(Payment payment) throws Exception 
	{
		long id=payment.getPaymentId();
		Supplier<Exception> s=()->new ResourceNotFoundException("Payment Id is not present in the Database");
		Payment p1=irepo.findById(id).orElseThrow(s);
		p1.setType(payment.getType());
		p1.setStatus(payment.getStatus());
		p1.setCard(payment.getCard());
		irepo.save(p1);
		return p1;	 
	}
/************************************************************************************************
		* Method             : getPaymentDetail
		* Description        : To get the Existing Payment detail by Id from the Database		                    
************************************************************************************************/		
	@Override
	public Payment getPaymentDetails(long id)throws Exception 
	{
		Supplier<Exception> s=()->new ResourceNotFoundException("Payment Id is not present in the Database");
		Payment p1=irepo.findById(id).orElseThrow(s);
		return p1;	
	}
/************************************************************************************************
	* Method             : getAllPaymentDetails
	* Description        : To get All the Existing Payment details as a List from the Database		                    
************************************************************************************************/		
	@Override
	public List<Payment> getAllPaymentDetails()
	{
		List<Payment> p1=new ArrayList<>();
		p1=irepo.findAll();
		return p1;
	}
}

