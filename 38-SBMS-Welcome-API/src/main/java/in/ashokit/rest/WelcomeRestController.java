package in.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.IGreetFiegnClient;

@RestController
public class WelcomeRestController {

	@Autowired
	
	@GetMapping("/welcome")
	public String welcomeMsg() {
		return "welcome to Ashok it";
	}
}
