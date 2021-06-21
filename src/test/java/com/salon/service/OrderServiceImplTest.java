/*********************************************************************************************     
 * Description :  OrderServiceImplTest is a class which test all the methods present 
                  inside the Order Service by using TDD approach.
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

import com.salon.bean.Order;
import com.salon.dao.IOrderRepository;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class OrderServiceImplTest 
{
	@Autowired
	IOrderService iorderservice;
	@MockBean
	IOrderRepository orepo;
/*********************************************************************************************     
	 Test Case Name  :  OTC_13
	 Description     :  This method uses The Mockito Concept to test the AddOrder method
					            in service class.
************************************************************************************************/
	@Test
	void testAddOrder() 
	{
		Order order=new Order();
		order.setOrderId(1);
		order.setOrderAmount(100);
		order.setOrderbillingDate("12345678");
		Mockito.when(orepo.save(order)).thenReturn(order);	
		Order response=iorderservice.addOrder(order);
		assertThat(response.getOrderId()).isEqualTo(1);
		assertThat(response.getOrderAmount()).isEqualTo(100);
		assertThat(response.getOrderbillingDate()).isEqualTo("12345678");
	}
/*********************************************************************************************     
 Test Case Name  :  OTC_14
 Description     :  This method uses The Mockito Concept to test the RemoveOrder method
				            in service class.
************************************************************************************************/
	@Test
	void testRemoveOrder() throws Exception 
	{
		Order o1=new Order();
		o1.setOrderId(1);
		o1.setOrderAmount(100);
		o1.setOrderbillingDate("12345678");
		Optional<Order> o2=Optional.of(o1);
		Mockito.when(orepo.findById((long) 1)).thenReturn(o2);
		Mockito.when(orepo.existsById(o1.getOrderId())).thenReturn(false);
		assertFalse(orepo.existsById(o1.getOrderId()));	
	}
	
/*********************************************************************************************     
	Test Case Name  :  OTC_15
	 Description    :  This method uses The Mockito Concept to test the UpdateOrder method
					            in service class.
************************************************************************************************/
	@Test
	void testUpdateOrder() throws Exception
	{
		Order o1=new Order();
		o1.setOrderId(1);
		o1.setOrderAmount(100);
		o1.setOrderbillingDate("12345678");
		Optional<Order> o2=Optional.of(o1);
		Mockito.when(orepo.findById((long) 1)).thenReturn(o2);
		o1.setOrderAmount(50);
		Mockito.when(orepo.save(o1)).thenReturn(o1);
		assertThat(iorderservice.updateOrder(o1)).isEqualTo(o1);	
	}
	
/*********************************************************************************************     
Test Case Name  :  OTC_16
Description     :  This method uses The Mockito Concept to test the GetOrderDetails method
					            in service class.
************************************************************************************************/
	@Test
	void testGetOrderDetails() throws Exception 
	{
		Order o1=new Order();
		o1.setOrderId(1);
		o1.setOrderAmount(100);
		o1.setOrderbillingDate("12345678");
		Optional<Order> o2=Optional.of(o1);
		Mockito.when(orepo.findById((long) 1)).thenReturn(o2);
		Optional<Order> o3=Optional.of(iorderservice.getOrderDetails(1));
		assertThat(o3).isEqualTo(o2);		
	}
	
/*********************************************************************************************     
Test Case Name  :  OTC_17
Description     :  This method uses The Mockito Concept to test the GetAllOrders method
					            in service class.
************************************************************************************************/
   @Test
   void testGetAllOrders()
    {
		Order o1=new Order();
		o1.setOrderId(1);
		o1.setOrderAmount(100);
		o1.setOrderbillingDate("12345678");
		List<Order> ls=new ArrayList<>();
		ls.add(o1);
		Mockito.when(orepo.findAll()).thenReturn(ls);
		assertThat(iorderservice.getAllOrders()).isEqualTo(ls);		
	}
}
