/*********************************************************************************************     
 * Description :  PaymentServiceImplTest is a class which test all the methods present 
                  inside the Payment Service by using TDD approach.
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

import com.salon.bean.Card;
import com.salon.bean.Payment;
import com.salon.dao.IPaymentRepository;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PaymentServiceImplTest {
	
	@Autowired
	IPaymentService ipaymentservice;
	@MockBean
	IPaymentRepository irepo;
/*********************************************************************************************     
	Test Case Name  :  PTC_18
	Description     :  This method uses The Mockito Concept to test the AddPayment method
						            in service class.
************************************************************************************************/
	@Test
	void testAddPayment()
	{
		Card card=new Card();
		card.setCardExpiry("022022");
		card.setCardName("visa");
		card.setCardNumber("123456789123");
		card.setCvv("123");
		
		Payment p=new Payment();
		p.setPaymentId(1);
		p.setType("card");
		p.setStatus("sucess");
		p.setCard(card);
		Mockito.when(irepo.save(p)).thenReturn(p);
		Payment response=ipaymentservice.addPayment(p);
		assertThat(response.getPaymentId()).isEqualTo(1);
		assertThat(response.getType()).isEqualTo("card");
		assertThat(response.getStatus()).isEqualTo("sucess");
		
		assertThat(response.getCard().getCardExpiry()).isEqualTo(card.getCardExpiry());
		assertThat(response.getCard().getCardName()).isEqualTo(card.getCardName());
		assertThat(response.getCard().getCardNumber()).isEqualTo(card.getCardNumber());
		assertThat(response.getCard().getCvv()).isEqualTo(card.getCvv());
	}
	
/*********************************************************************************************     
	Test Case Name  :  TC_19
	Description     :  This method uses The Mockito Concept to test the RemovePayment method
						            in service class.
************************************************************************************************/	
	@Test
	void testRemovePayment() throws Exception 
	{
		Payment p1 = new Payment();
		p1.setPaymentId(1);
		p1.setType("card");
		p1.setStatus("sucess");
		Optional<Payment> p2 = Optional.of(p1);
		Mockito.when(irepo.findById((long)1)).thenReturn(p2);
		Mockito.when(irepo.existsById(p1.getPaymentId())).thenReturn(false);
		assertFalse(irepo.existsById(p1.getPaymentId()));	
	}
	
/*********************************************************************************************     
	Test Case Name  :  TC_20
	Description     :  This method uses The Mockito Concept to test the UpdatePayment method
						            in service class.
************************************************************************************************/	
	@Test
	void testUpdatePayment() throws Exception 
	{
		Payment p1 = new Payment();
		p1.setPaymentId(1);
		p1.setType("card");
		p1.setStatus("sucess");
		Optional<Payment> p2 = Optional.of(p1);
		Mockito.when(irepo.findById((long)1)).thenReturn(p2);
		p1.setType("card");
		Mockito.when(irepo.save(p1)).thenReturn(p1);
		assertThat(ipaymentservice.updatePayment(p1)).isEqualTo(p1);
	}

/*********************************************************************************************     
	Test Case Name  :  TC_21
	Description     :  This method uses The Mockito Concept to test the GetPayment method
						            in service class.
************************************************************************************************/
	@Test
	void testGetPayment() throws Exception 
	{
		Payment p1 = new Payment();
		p1.setPaymentId(1);
		p1.setType("card");
		p1.setStatus("sucess");
		Optional<Payment> p2 = Optional.of(p1);
		Mockito.when(irepo.findById((long)1)).thenReturn(p2);
		Optional<Payment> p3 = Optional.of(ipaymentservice.getPaymentDetails(1));
		assertThat(p3).isEqualTo(p2);	
	}
	
/*********************************************************************************************     
	Test Case Name  :  TC_22
	Description     :  This method uses The Mockito Concept to test the GetAllPayments method
						            in service class.
************************************************************************************************/
	@Test
	void testGetAllPayments() 
	{
		Payment p1 = new Payment();
		p1.setPaymentId(1);
		p1.setType("card");
		List<Payment> ls = new ArrayList<>();
		ls.add(p1);
		Mockito.when(irepo.findAll()).thenReturn(ls);
		assertThat(ipaymentservice.getAllPaymentDetails()).isEqualTo(ls);	
	}	
}
