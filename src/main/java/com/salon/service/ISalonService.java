/*********************************************************************************************
 * Description    : It is the Salon Service Interface that contains various methods of 
                    Salon Service Module
 *********************************************************************************************/
package com.salon.service;

import java.util.List;

import com.salon.bean.SalonService;

public interface ISalonService 
{
	public SalonService addService(SalonService salonService);
    public String removeService(long id) throws Exception;
	public SalonService updateService(SalonService e) throws Exception;
	public SalonService getService(long id) throws Exception;
	public List<SalonService> getAllServices();
	public List<SalonService> getServiceByName(String ServiceName);
    public List<SalonService> getServiceByPrice(double ServicePrice);
    public List<SalonService> getServiceDuration(String serviceDuration);
}
