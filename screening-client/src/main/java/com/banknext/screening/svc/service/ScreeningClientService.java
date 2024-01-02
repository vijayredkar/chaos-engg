package com.banknext.screening.svc.service;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.banknext.txn.Entity;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ScreeningClientService {
	

	@Autowired 
	RestTemplate restTemplate;	//has 5 seconds timeout configured at app start up

	Log LOGGER = LogFactory.getLog(ScreeningClientService.class);
		
	public String  entityScreening() {
		
		LOGGER.info("\n\n" );
		LOGGER.info("**** client started." );
		String isScreeningPass = null ;	
		String result = "User has FAILED compliance checks. Loan denied";
		
	    		//has 5 seconds timeout configured at app start up
			try 
			{
		    		isScreeningPass = restTemplate.getForObject("http://localhost:8080/compliance/v1/screen-1", String.class);
			}
			catch(Exception e)
			{
				LOGGER.error("**** Rest call failed" );
			}
	    		
	    		if(isScreeningPass.length() > 0 && "true".equals(isScreeningPass))
	    		{
	    			result = "User has PASSED compliance checks. Loan sanctioned.";	    		
	    		}
	    
	    	LOGGER.info("**** client completed." );	
	        return result;
	        
	        
	        
	        

    		/*
    		RestTemplate restTemplate = new RestTemplate();
    		isScreeningPass = restTemplate.getForObject("http://localhost:8080/compliance/v1/screen-1", String.class);
    		*/
    		/*
    		ResponseEntity<String> isScreeningPassResponseEntity = restTemplate.getForEntity("http://localhost:8080/compliance/v1/screen-1", String.class);
    		ObjectMapper mapper = new ObjectMapper();
    		JsonNode root = mapper.readTree(isScreeningPassResponseEntity.getBody());
    		*/
	}
}