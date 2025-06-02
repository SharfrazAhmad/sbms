package in.ashokit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

	@GetMapping("/welcome")
	public ModelAndView welcomeMsg() {
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("msg", "Wecome to Spring boot");
		modelAndView.setViewName("welcome");
		return modelAndView; 
	}
	
}
