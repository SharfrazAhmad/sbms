package in.nit.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.nit.binding.PassangerInfo;
import in.nit.binding.TicketInfo;

@RestController
public class TicketRESTController {

	@PostMapping("/ticket")
	public ResponseEntity<TicketInfo> addPassanger(@RequestBody PassangerInfo passangerInfo) {
		TicketInfo ticketInfo = new TicketInfo(10001, "1245hj", "Confirmed");
		System.out.println(passangerInfo);
		return new ResponseEntity<TicketInfo>(ticketInfo, HttpStatus.OK);
	}
}
