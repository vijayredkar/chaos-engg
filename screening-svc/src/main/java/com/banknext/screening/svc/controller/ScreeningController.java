package com.banknext.screening.svc.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banknext.screening.svc.service.ScreeningService;
import com.banknext.txn.Entity;

@RestController
@RequestMapping(value = "/compliance/v1/")
public class ScreeningController {
	
	Log LOGGER = LogFactory.getLog(ScreeningController.class);
	String result = "System error occurred";
	
	@Autowired
	ScreeningService screeningSvc;
	
	
	@GetMapping(value = "/screen-1")
	public String screen() 
	{			
		return screeningSvc.entityScreening();
	}
	

	@GetMapping(value = "/screen-2")
	public String screen1() 
	{			
		try
		{
			result = screeningSvc.entityScreening();
		}
		catch(Exception e )
		{
			LOGGER.info("\n" );
			LOGGER.info("***** Exception occurred.");
			LOGGER.info("**** Activating fallback mechanism.");
		}
		
		return result;
	}
}