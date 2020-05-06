package com.uds.consul;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@ConfigurationProperties(prefix="dev")
@Data
public class ConsulConfig {
 
	private String username;
	private String password;
	
}
