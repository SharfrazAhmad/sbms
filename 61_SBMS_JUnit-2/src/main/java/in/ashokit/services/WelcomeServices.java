package in.ashokit.services;

import org.springframework.stereotype.Service;

@Service
public class WelcomeServices {

	public String getWelcomeMsg() {
		return "hello world! ";
	}
	
}
