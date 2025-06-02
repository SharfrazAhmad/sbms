package in.ashokit.rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.props.AppProperties;

@RestController
public class DemoRestController {

	@Autowired
	private AppProperties props;

	@GetMapping("/welcome")
	public String welcomeMsg() {
		Map<String, String> map = props.getMessages();
		String value = map.get("welcome");
		return value;
	}

	@GetMapping("/greet")
	public String greetMsg() {
		Map<String,String> messages = props.getMessages();
		String value = messages.get("greet");
		return value;
	}
	
	@GetMapping("/wish")
	public String wishMsg() {
		return props.getMessages().get("wish");
	}
}
