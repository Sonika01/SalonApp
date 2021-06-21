/*********************************************************************************************
 * Description    : It is the Order Interface that contains various methods of 
                    Customer Module
 *********************************************************************************************/
package com.salon.service;

import java.util.List;

import com.salon.bean.Order;

public interface IOrderService 
{
	public Order addOrder(Order order);
	public String removeOrder(long id) throws Exception;
	public Order updateOrder(Order e) throws Exception;
	public Order getOrderDetails(long id) throws Exception;
	public List<Order> getAllOrders();
	
}
