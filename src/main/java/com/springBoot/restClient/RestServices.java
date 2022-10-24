package com.springBoot.restClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RestServices {
	
	
	private static final Logger logger = LoggerFactory.getLogger(RestServices.class);
	
	
	@GetMapping(value="/")
	public ResponseEntity<String>pong(){
		return new ResponseEntity<String>("Reponse du serveur:"+HttpStatus.OK.name(),HttpStatus.OK);
	}

}
