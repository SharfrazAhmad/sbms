package in.ashokit.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.bindings.UserAccForm;
import in.ashokit.services.AccountService;

@RestController
public class AccountRestController {

	private Logger logger = LoggerFactory.getLogger(AccountRestController.class);

	@Autowired
	private AccountService accServices;

	@PostMapping("/user")
	public ResponseEntity<String> createAccount(@RequestBody UserAccForm userAccForm) {

		logger.debug("Account creation process successfull");
		boolean status = accServices.createUserAccount(userAccForm);
		logger.debug("Account creation process completed");

		if (status) {
			logger.info("Account created successfully");
			return new ResponseEntity<String>("Account Created", HttpStatus.CREATED);
		} else {
			logger.info("Account creation failed");
			return new ResponseEntity<String>("Account Creation Failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/users")
	public ResponseEntity<List<UserAccForm>> getUsers() {
		
		logger.debug("Fetching User Accounts process started");
		List<UserAccForm> userAccounts = accServices.fetchUserAccounts();
		logger.debug("Fetching User Accounts process completed");
		logger.info("User Accounts Fetched Successfully");
		return new ResponseEntity<>(userAccounts, HttpStatus.OK);
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<UserAccForm> getUser(@PathVariable("userId") Long userId) {
		logger.debug("User account fetcjing started");
		UserAccForm userAccById = accServices.getUserAccById(userId);
		logger.info("User account fetched successfully");
		return new ResponseEntity<UserAccForm>(userAccById, HttpStatus.OK);
	}

	@PutMapping("/user/{userId}/{status}")
	public ResponseEntity<List<UserAccForm>> updateUserAcc(@PathVariable("userId") Integer userId,
			@PathVariable("status") String status) {
		logger.debug("User account update process started");
		accServices.changeAccStatus(userId, status);
		logger.debug("User account update process completed");
		logger.info("User Account status updated successfully");
		List<UserAccForm> userAccounts = accServices.fetchUserAccounts();
		return new ResponseEntity<>(userAccounts, HttpStatus.OK);
	}

}
