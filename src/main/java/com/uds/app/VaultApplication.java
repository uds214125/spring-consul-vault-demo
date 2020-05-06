package com.uds.app;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
 
@PropertySource(ignoreResourceNotFound = true, value = "classpath:application.dev.properties")
@SpringBootApplication
@ComponentScan(basePackages = "com.uds.*")
@EnableConfigurationProperties(AppProperties.class)
public class VaultApplication implements CommandLineRunner {
	@Autowired
	private AppProperties appProperties;

 
	@Value("${app.username}")
    private String name;
	 
	public static void main(String[] args) {
		SpringApplication.run(VaultApplication.class, args);
	}

	  @Override
	  public void run(String... args) {
	
	    Logger logger = LoggerFactory.getLogger(VaultApplication.class);
	
	    logger.info("----------------------------------------");
	    logger.info("Configuration properties {} ", name);
	    logger.info("   username is {}", appProperties.getUsername());
	    logger.info("   password is {}", appProperties.getPassword());
	    logger.info("----------------------------------------");
	  }
}