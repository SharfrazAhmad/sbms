package in.ashokit.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomrRESTController {

	@GetMapping("/welcome")
	public ResponseEntity<String> getWelcomeMsg(@RequestParam("name") String name) {
		String resPayload = name + " Welcome to Ashok it";
		return new ResponseEntity<>(resPayload, HttpStatus.OK);
	}

	@GetMapping("/greet")
	public String getGreet() {
		String payLoad = "hello how r u";
		return payLoad;
	}
}
