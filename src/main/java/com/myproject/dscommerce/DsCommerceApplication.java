package com.myproject.dscommerce;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DsCommerceApplication implements CommandLineRunner{
	
	/*@Autowired
	private PasswordEncoder passwordEncoder;*/
	
    public static void main(String[] args) {
        SpringApplication.run(DsCommerceApplication.class, args);
        
    }

	@Override
	public void run(String... args) throws Exception {
		//System.out.println("Encode: " + passwordEncoder.encode("123456"));
		
	}
}