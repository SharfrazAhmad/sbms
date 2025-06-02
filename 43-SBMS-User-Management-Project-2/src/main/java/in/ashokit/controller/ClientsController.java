package in.ashokit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import in.ashokit.model.Client;
import in.ashokit.repository.ClientRepository;


@Controller
@RequestMapping("/clients")
public class ClientsController {

	@Autowired
	private ClientRepository clientRepo;
	
	@GetMapping({"","/"})
	public String getClients(Model model) {
		 List<Client> clients = clientRepo.findAll(Sort.by(Sort.Direction.ASC,"id"));
		model.addAttribute("clients",clients);
		
		return "clients/index";
	}
	
	
}
