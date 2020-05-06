package com.uds.consul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@EnableConfigurationProperties(ConsulConfig.class)
public class ConsulController {
	@Autowired 
	ConsulConfig consulConfig;
	
	   @GetMapping("/config")
	   public ConsulConfig getConsoleConfiguration() {
		   System.out.println(" : Get configuration from Consul Server :");
	       return consulConfig;
	   }
}