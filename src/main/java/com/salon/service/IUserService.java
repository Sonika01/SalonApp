/*********************************************************************************************
 * Description    : It is the User Interface that contains various methods of 
                    User Module
 *********************************************************************************************/
package com.salon.service;

import com.salon.bean.Customer;
import com.salon.bean.User;

public interface IUserService 
{
	public User createUser(User u);
	public Customer signIn(Long userId,String password) throws Exception;
	public User ChangeUserpassword(Long userId,String password,String newpassword) throws Exception;
	public User SignOut(Long userId) throws Exception;

}
