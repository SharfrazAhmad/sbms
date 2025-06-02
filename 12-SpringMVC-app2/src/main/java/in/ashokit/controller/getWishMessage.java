package in.ashokit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class getWishMessage {

	@GetMapping("wish")
	public ModelAndView getWish() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("msg", "happpy birthday");
		modelAndView.setViewName("wish");

		return modelAndView;
	}
}
