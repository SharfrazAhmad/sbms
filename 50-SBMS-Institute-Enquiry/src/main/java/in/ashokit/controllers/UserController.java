package in.ashokit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ashokit.binding.LoginForm;
import in.ashokit.binding.SignUpForm;
import in.ashokit.binding.UnlockForm;
import in.ashokit.services.UserServices;

@Controller
public class UserController {
	
	@Autowired
	private UserServices userServices;
	

	
	@PostMapping("/signup")
	public String handleSignUp(@ModelAttribute ("user") SignUpForm form, Model model) {
		boolean status=userServices.signUp(form);
		if(status) {
			model.addAttribute("succMsg","Check your mail");
		}
		else {
			model.addAttribute("errMsg","Problem occured: Email Alredy exist by a user");
		}
		return "signup";
	}
	
	@GetMapping("/signup")
	public String signUpPage(Model model) {
		model.addAttribute("user",new SignUpForm());
		return "signup";
	}
	
	
	@GetMapping("/unlock")
	public String unlockPage(Model model, @RequestParam String email) {
		UnlockForm unlockForm = new UnlockForm();
		unlockForm.setEmail(email);
		model.addAttribute("unlockForm",unlockForm);
		return "unlock";
	}
	
	@PostMapping("/unlock")
	public String UnlockUserAccount(@ModelAttribute UnlockForm unlock, Model model) {
	    System.out.println(unlock);

	    if (unlock.getNewPwd().equals(unlock.getConfirmPwd())) {
	        boolean status = userServices.unlockAccount(unlock);
	        if (status) {
	        	 model.addAttribute("succMsg", "Success, The password is updated");
	        } else {
	            model.addAttribute("errMsg", "Your temporary password is incorrect");
	        }
	    } else {
	        model.addAttribute("errMsg", "New Password and Confirm Password should be the same");
	    }
	    return "unlock";
	}

	@GetMapping("/login")
	public String loginPage(Model model) {
		model.addAttribute("loginForm",new LoginForm());
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute("loginForm") LoginForm loginForm, Model model) {
		String status = userServices.login(loginForm);
		if (status.contains("success")) {
			return "redirect:/dashboard";
		}
		model.addAttribute("errMsg",status);
		return "login";
	}
	
	
	
	@GetMapping("/forgot")
	public String forgotPwdPage() {
		return "forgotPwd";
	}
	
	@PostMapping("/forgotPwd")
	public String forgotPwdPage(@RequestParam("email") String email, Model model) {
		boolean status = userServices.forgotPwd(email);
		if(status) {
			model.addAttribute("succMsg","Password sent to your mail");
		}
		else {
			model.addAttribute("errMsg","Invalid mail");
		}
		return "forgotPwd";
	}
	
	
}
