package com.uds.vault;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponse;
import org.springframework.vault.support.VaultResponseSupport;


@SpringBootTest
class VaultApplicationTests {

  @Test
  public void vaultTest() throws URISyntaxException{

     //client
     VaultTemplate vaultTemplate = new VaultTemplate(
  		VaultEndpoint.from(new URI("http://127.0.0.1:8200")),
  		new TokenAuthentication("00000000-0000-0000-0000-000000000000")
  	);
  	
  	//Request : create these credentials in vault
  	VaultResponse response = vaultTemplate.write("cubbyhole/admin",
  		new AdminSecret("uds","udp")
  	);
  	
  	assertNull(response);
  	
  	VaultResponseSupport<AdminSecret> resp = vaultTemplate.read("cubbyhole/admin", AdminSecret.class);
  	
  	assertEquals("uds", resp.getData().getUsername());
  	assertEquals("udp", resp.getData().getPassword());
  	System.out.println(" resp : "+resp.toString());
  }


  public static class AdminSecret{
  	private String username;
  	private String password;
  	public AdminSecret() {}
	public AdminSecret(String username, String password) {
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "AdminSecret [username=" + username + ", password=" + password + ", getUsername()=" + getUsername()
				+ ", getPassword()=" + getPassword() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
  }
  	
}
