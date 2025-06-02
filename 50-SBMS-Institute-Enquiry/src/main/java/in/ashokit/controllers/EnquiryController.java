package in.ashokit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import in.ashokit.binding.DashboardResponse;
import in.ashokit.services.EnquiryService;
import jakarta.servlet.http.HttpSession;

@Controller
public class EnquiryController {

	@Autowired
	private EnquiryService enquiryService;
	
	@Autowired
	private HttpSession session;
	
	
	@GetMapping("/logout")
	public String logout() {
		session.invalidate();
		return "index";
	}
	
	
	@GetMapping("/dashboard")
	public String dashboardPage(Model model) {
		Integer userId = (Integer) session.getAttribute("userId");
		DashboardResponse dashboardData = enquiryService.getDashboardData(userId);
		model.addAttribute("dashboardData",dashboardData);
		return "dashboard";
	}

	@GetMapping("/enquiry")
	public String addEnquiryPage() {
		return "add-enquiry";
	}

	@GetMapping("/enquiries")
	public String viewEnquiriesPage() {
		return "view-enquiries";
	}

}
