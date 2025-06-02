package in.ashokit.beans;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class Motor {

	public Motor() {
		System.out.println("Motor.Motor(): cons. called");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("Motor.init() started");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Motor.destroy() destroyed");
	}

	
}
