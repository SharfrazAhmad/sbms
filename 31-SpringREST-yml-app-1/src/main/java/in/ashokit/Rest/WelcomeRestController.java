package in.ashokit.Rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRestController {
	
	@Value("${welcome.msg}")
	private String msg="Welcome home";
	
	@GetMapping("/")
	public String welcomeMsg() {
		return msg;
	}
}
