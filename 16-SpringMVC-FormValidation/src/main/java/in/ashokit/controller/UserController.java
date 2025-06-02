package in.ashokit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.ashokit.binding.User;
import jakarta.validation.Valid;

@Controller
public class UserController {

	@GetMapping("/")
	public String getForm(Model model) {
		User userObj = new User();
		model.addAttribute("user", userObj);
		return "index";
	}

	@PostMapping("/register")
	public String handleRegisterBtn(@Valid User userForm, Model model, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "index";
		}

		System.out.println(userForm);
		model.addAttribute("msg", "Your registration is successfull");
		return "success";
	}
}
