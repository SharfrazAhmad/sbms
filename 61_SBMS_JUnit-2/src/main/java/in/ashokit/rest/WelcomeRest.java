package in.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.services.WelcomeServices;

@RestController
public class WelcomeRest {

	@Autowired
	private WelcomeServices welcomeServices;
	
	@GetMapping("/welcome")
	public ResponseEntity<String> welcomeMsg() {
		String welcomeMsg = welcomeServices.getWelcomeMsg();
		return new ResponseEntity<String>(welcomeMsg, HttpStatus.OK);
		
		
	}
}
