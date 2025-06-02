package in.ashokit.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ch.qos.logback.core.model.Model;


@Controller
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping("/users")
	public String showUserList(Model model) {
	    List<User> listAll = service.listAll();
	    model.addAttribute("users", listAll); // Corrected line
	    return "users";
	}
	
	
}
