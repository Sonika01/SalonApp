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
@Table(name="Users")
public class User
{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
	
	@NotNull
	@Size(min=6,message="Password atleast 6 character in length")
	@Column(name="Password")
	private String password;
	
	@NotNull
	@Column(name="Role")
	private String role;
	
	public User() 
	{
		
	}
	
	public User(@NotNull @Size(min = 6, message = "Password atleast 6 character in length") String password,
			@NotNull String role) 
	{
		super();
		this.password = password;
		this.role = role;
	}

	public Long getUserId() 
	{
		return userId;
	}

	public void setUserId(Long userId) 
	{
		this.userId = userId;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public String getRole() 
	{
		return role;
	}

	public void setRole(String role) 
	{
		this.role = role;
	}

	@Override
	public String toString()
	{
		return "User [userId=" + userId + ", password=" + password + ", role=" + role + "]";
	}
	
}

