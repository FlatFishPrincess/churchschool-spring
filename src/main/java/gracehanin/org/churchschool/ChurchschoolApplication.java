package gracehanin.org.churchschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

// https://www.baeldung.com/spring-boot-security-autoconfiguration
// disabling security is not a good way, need to add configure later. but now I don't consider it
// refer websecurityconfig.java
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class ChurchschoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChurchschoolApplication.class, args);
	}

}
