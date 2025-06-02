package in.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import in.ashokit.entity.Patient;
import in.ashokit.service.PatientService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/patients")
public class PatientController {

	@Autowired
	private PatientService patientService;

	@GetMapping
	public String listPatients(Model model) {
		model.addAttribute("patients", patientService.getAllPatients());
		return "Patients";
	}

	@GetMapping("/new")
	public String showAddForm(Model model) {
		model.addAttribute("patient", new Patient());
		return "patient-form";
	}

	@PostMapping
	public String savePatient(@Valid @ModelAttribute("patients") Patient patient, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "patient-form";
		}
		patientService.savePatient(patient);
		return "redirect:/patients";
	}

//	--------------------------------
	@GetMapping("/edit/{id}")
	public String showEditForm(@PathVariable Long id, Model model) {
		model.addAttribute("patient", patientService.getPatientsById(id));
		return "patient-form";
	}

	@GetMapping("/delete/{id}")
	public String deletePatient(@PathVariable Long id) {
		patientService.deletePatient(id);
		return "redirect:/patients";
	}

}
