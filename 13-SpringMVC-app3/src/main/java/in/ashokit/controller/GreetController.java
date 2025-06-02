package in.ashokit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class GreetController {

	public String getGreet(Model model) {
		String msgTxt = "good morning";
		model.addAttribute("msg",msgTxt);
		
		return "greet";
	}
	
}
