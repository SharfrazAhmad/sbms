package in.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.entity.Account;
import in.ashokit.service.AccountService;

@RestController
@RequestMapping("account")
public class AccountController {
	
	@Autowired
	AccountService service;
	
	@PostMapping ("/create")
	public Account  createAccount(@RequestBody Account account) {
		Account account2 = service.createAccount(account);
		return account2;
	}
	
}
