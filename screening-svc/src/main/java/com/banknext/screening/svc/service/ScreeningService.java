package com.banknext.screening.svc.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.banknext.txn.Entity;


@Service
public class ScreeningService {

	Log LOGGER = LogFactory.getLog(ScreeningService.class);
		
	public String  entityScreening() {
		
		String isScreeningPass = "false";
		String result = "User has FAILED compliance checks. Loan denied";
	    	try {
	    		
	    		LOGGER.info("\n\n" );
	    		LOGGER.info("---- screening started." );
	    		Thread.sleep(1000); //artificial delay - simulate processing	    		
	    		LOGGER.info("---- user profile scan complete." );
	    		Thread.sleep(1000); 
	    		LOGGER.info("---- legal checks complete." );
	    		Thread.sleep(1000); 
	    		LOGGER.info("---- travel hsitory checks complete." );
	    		Thread.sleep(1000);	    		
	    		LOGGER.info("---- screening completed" );
	    
	    		isScreeningPass = "true";
	    		
	    		
	    		if("true".equals(isScreeningPass))
	    		{
	    			result = "User has PASSED compliance checks. Loan sanctioned.";	    		
	    		}	    		
	    		
			} catch (InterruptedException e) {				
				LOGGER.error("---- screening error occurred " + e );
			}
	    	
	        return result;	        
	}
}