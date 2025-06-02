package in.ashokit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.ashokit.entity.CitizenPlan;
import in.ashokit.request.SearchRequest;
import in.ashokit.service.ReportService;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ReportController {

	@Autowired
	private ReportService service;

	@GetMapping("/excel")
    public void exportExcel(HttpServletResponse response) throws Exception {
		response.setContentType("application/vnd.ms-excel");

        
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=plans.xls";
        response.setHeader(headerKey, headerValue);
         
        
        service.exportExcel(response);
	}
	
	@PostMapping("/search")
	public String handleSearch(SearchRequest request,Model model){
		System.out.println(request);
		
		List<CitizenPlan> plans = service.search(request);
		model.addAttribute("plans",plans);
		
		init(model);
	return "index";
		
	}
	
	
	@GetMapping("/")
	public String indexPage(Model model) {
		
		init(model);

		return "index";
	}


	private void init(Model model) {
		model.addAttribute("search",new SearchRequest());
		model.addAttribute("names",service.getPlanNames());
		model.addAttribute("status",service.getPlanStatus());
	}
}
