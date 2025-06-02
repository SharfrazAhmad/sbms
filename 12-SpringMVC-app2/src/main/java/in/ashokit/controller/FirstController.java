package in.ashokit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FirstController {

	@GetMapping("/welcome")
	public ModelAndView getModelAndView() {

		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "https://www.google.com/");
		mav.setViewName("welcome");

		return mav;

	}
	
	@GetMapping("/greet")
	public ModelAndView greetView() {
		ModelAndView greetView = new ModelAndView();
		
		greetView.addObject("greet", "Nice to see you");
		greetView.setViewName("greet");
		return greetView;
		
		
	}
	
	
}
