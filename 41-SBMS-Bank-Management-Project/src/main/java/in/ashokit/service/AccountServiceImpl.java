package in.ashokit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.Account;
import in.ashokit.repository.IAccountRepository;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	IAccountRepository repository;
	
	@Override
	public Account createAccount(Account account) {
		Account save = repository.save(account);
		return save;
	}

	@Override
	public Account getAccountDetailsByAccountNumber(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> getAllAccountDetails(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account depositeAmount(Long accountNumber, Double amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account withdrawAmount(Long accountNumber, Double amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void closeAccount(Long accountNumber) {
		// TODO Auto-generated method stub
		
	}
	
}
