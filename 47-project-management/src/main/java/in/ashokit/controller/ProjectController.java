package in.ashokit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import in.ashokit.entity.Project;
import in.ashokit.service.ProjectService;

@Controller
public class ProjectController {

	
	
	@Autowired
	private ProjectService projectService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/getAllProjects")
	public String getAllProjects(Model model) {
		List<Project> projects = projectService.getAllProjects();
		model.addAttribute("projects",projects);
		return "projects";
	}
	
	@GetMapping("/addProject")
	public String addProject(Model model) {
		model.addAttribute(new Project());
		return "add_project";
	}
	
}
