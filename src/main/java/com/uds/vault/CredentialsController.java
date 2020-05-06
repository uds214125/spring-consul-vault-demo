package com.uds.vault;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



//@PropertySource(ignoreResourceNotFound = true, value = "classpath:application.dev.properties")
@RestController
@RequestMapping(value = "api")
public class CredentialsController {
    Logger logger = LoggerFactory.getLogger(CredentialsController.class);
	@Value("${app.username}")
    private String username;
	
	@Value("${app.password}")
    private String password;
    
    @Autowired
    CredentialsService credService;
    
    @GetMapping
	public String getTest() {
    	return "OK TEST";
    }
	@GetMapping("/credentials")
	public Credentials getCredentials() {
		logger.info("----------------------------------------");
		logger.info("Get credentials from vault : {}  ", credService.getCredentials().getUsername());
		logger.info("----------------------------------------");
		return credService.getCredentials();	 
	}
	@PostMapping("/credentials")
	public String setCredentials(@RequestBody @Valid Credentials creds) {
		logger.info("Set credentials into vault"); 
		Credentials credentials = new Credentials(
				(creds.getUsername()!=null) ?creds.getUsername():username,
				(creds.getPassword() !=null)?creds.getPassword():password
			);
		credService.setCredentials(credentials);			
		return "OK";
	}
    
 
}
