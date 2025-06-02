package in.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.constants.AppConstants;
import in.ashokit.props.AppProperties;

@RestController
public class MsgRestController {

	@Autowired
	private AppProperties appProperties;

	@GetMapping("/welcome")
	public String getWelcomeMsg() {
		return appProperties.getMessages().get(AppConstants.WELCOME_MSG_KEY);
	}

	@GetMapping("/greet")
	public String getGreetMsg() {
		return appProperties.getMessages().get(AppConstants.GREET_MSG_KEY);
	}
}
