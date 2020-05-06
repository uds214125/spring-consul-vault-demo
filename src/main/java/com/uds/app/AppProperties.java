package com.uds.app;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;


@ConfigurationProperties(prefix = "app")
public class AppProperties {
	@Setter @Getter
    private String username;
	@Setter @Getter
    private String password;
	@Override
	public String toString() {
		return "AppProperties [username=" + username + ", password=" + password + ", getUsername()=" + getUsername()
				+ ", getPassword()=" + getPassword() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
    
}
