package com.banknext.screening.svc.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banknext.screening.svc.service.ScreeningClientService;
import com.banknext.txn.Entity;

@RestController
@RequestMapping(value = "/loan/v1/")
public class ScreeningClientController {
	
	Log LOGGER = LogFactory.getLog(ScreeningClientController.class);
	String result = "System error occurred";
	
	@Autowired
	ScreeningClientService screeningSvc;
	
	
	@GetMapping(value = "/screen-1")
	public String screen1() 
	{			
		return screeningSvc.entityScreening();
	}
	

	@GetMapping(value = "/screen-2")
	public String screen2() 
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