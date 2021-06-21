/*********************************************************************************************
* Description   : It is a Order Service Implementation class that defines/overrides
                   the methods mentioned in its Interface (Order Interface).
  
***********************************************************************************************/
package com.salon.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.salon.bean.Order;
import com.salon.dao.IOrderRepository;

@Service
public class OrderServiceImpl implements IOrderService
{
	
	@Autowired
	IOrderRepository orepo;
/************************************************************************************************
	* Method             : addOrder
	* Description        : To add the new Order detail to the Database		                    
************************************************************************************************/	
	@Override
	public Order addOrder(Order order) 
	{
		Order o1=orepo.save(order);
		return o1;
	}
/************************************************************************************************
	* Method             : removeOrder
	* Description        : To remove the Existing Order detail from the Database		                    
************************************************************************************************/	
	@Override
	public String removeOrder(long id) throws Exception 
	{
		Supplier<Exception> o2 = ()->new ResourceNotFoundException("Order id is not present in the database");
		Order e1=orepo.findById(id).orElseThrow(o2);
		orepo.deleteById(id);
	    return  "Deleted Successful";	
	}
/************************************************************************************************
	* Method             : updateOrder
	* Description        : To update the Existing Order detail present in the Database		                    
************************************************************************************************/	
	@Override
    public Order updateOrder(Order e) throws Exception  
	{
		long id=e.getOrderId();
		Supplier<Exception> o1 = ()->new ResourceNotFoundException("Order id is not present in the database");
		Order e1=orepo.findById(id).orElseThrow(o1);
		e1.setOrderId(e.getOrderId());
		e1.setOrderAmount(e.getOrderAmount());
		e1.setOrderbillingDate(e.getOrderbillingDate());
		e1.setPayment(e.getPayment());
			orepo.save(e1);
			return e1;	
	}
/************************************************************************************************
	* Method             : getOrderDetail
	* Description        : To get the Existing Order detail by Id from the Database		                    
************************************************************************************************/
	 @Override
	 public Order getOrderDetails(long id) throws Exception 
	 {
	    	Supplier<Exception> s2 = ()->new ResourceNotFoundException("Order id is not present in the database");
	    	Order o1=orepo.findById(id).orElseThrow(s2);
			return o1;	
	 }	
/************************************************************************************************
		* Method             : getAllOrderDetails
		* Description        : To get All the Existing Order details as a List from the Database		                    
************************************************************************************************/
    @Override
	public List<Order> getAllOrders()
    {
		List<Order> ls=new ArrayList<>();
		ls=orepo.findAll();
		return ls;
	}
    
}


