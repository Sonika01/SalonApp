/*************************************************************************************************
* Description   : It is a Salon Service Implementation class that defines/overrides
                   the methods mentioned in its Interface (User Interface).
**************************************************************************************************/
package com.salon.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;


import com.salon.bean.SalonService;
import com.salon.dao.ISalonRepository;

@Service
public class SalonServiceImpl implements ISalonService
{
	@Autowired
	ISalonRepository srepo;

/************************************************************************************************
	* Method             : addService
	* Description        : To add the new Salon Service into the Database	                    
************************************************************************************************/
	@Override
	public SalonService addService(SalonService salonService) 
	{
		SalonService s1=srepo.save(salonService);
		return s1;
	}
/************************************************************************************************
	* Method             : removeService
	* Description        : To remove the new Salon Service into the Database	                    
************************************************************************************************/
	@Override
	public String removeService(long id) throws Exception 
	{
		Supplier<Exception> s2 = ()->new ResourceNotFoundException("Service id is not present in the database");
		srepo.findById(id).orElseThrow(s2);
		srepo.deleteById(id);
	    return  "Deleted Successful";	
	}
/************************************************************************************************
	* Method             : updateService
	* Description        : To update the Existing Salon Service by Id in the Database	                    
************************************************************************************************/
	@Override
    public SalonService updateService(SalonService e) throws Exception  
	{
		long id=e.getServiceId();
		Supplier<Exception> s1 = ()->new ResourceNotFoundException("Service id is not present in the database");
		SalonService e1=srepo.findById(id).orElseThrow(s1);
		e1.setServiceName(e.getServiceName());
		    e1.setDiscount(e.getDiscount());
		    e1.setServicePrice(e.getServicePrice());
		    e1.setServiceDuration(e.getServiceDuration());
			srepo.save(e1);
			return e1;	
	}
/************************************************************************************************
	* Method             : getService
	* Description        : To Get the Existing Salon Service by Id from the Database	                    
*************************************************************************************************/
    @Override
	public SalonService getService(long id) throws Exception 
    {
    	Supplier<Exception> s2 = ()->new ResourceNotFoundException("Service id is not present in the database");
    return srepo.findById(id).orElseThrow(s2);
		
	}
/************************************************************************************************
	* Method             : getAllServices
	* Description        : To Get All the Existing Salon Services as List from the Database	                    
************************************************************************************************/
    @Override
	public List<SalonService> getAllServices()
    {
		List<SalonService> ls=new ArrayList<>();
		ls=srepo.findAll();
		return ls;
	}
/************************************************************************************************
* Method             : getServiceByName
* Description        : To Get All the Existing Salon Services By their Name in the form of List                    
************************************************************************************************/
    @Override
    public List<SalonService> getServiceByName(String ServiceName)
    {
		return srepo.findByServiceName(ServiceName);
	}
/************************************************************************************************
 * Method             : getServiceByPrice
 * Description        : To Get All the Existing Salon Services By their Price in the form of List                    
************************************************************************************************/
    @Override
	public List<SalonService> getServiceByPrice(double ServicePrice)
    {
		return srepo.findByServicePrice(ServicePrice);
	}
 /************************************************************************************************
 * Method             : getServiceByDuration
 * Description        : To Get All the Existing Salon Services By their Duration in the form of List                    
 ************************************************************************************************/
    @Override
    public List<SalonService> getServiceDuration(String serviceDuration)
    {
		return srepo.findByServiceDuration(serviceDuration);	
	}
}
