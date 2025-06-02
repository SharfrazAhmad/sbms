package in.ashokit.service;

import java.util.List;

import in.ashokit.entity.Account;

public interface AccountService {
	
	public Account	 createAccount(Account account);
	public Account	 getAccountDetailsByAccountNumber(Account account);
	public List<Account>	getAllAccountDetails(Account account);
	public Account	 depositeAmount(Long accountNumber,Double amount);
	public Account	 withdrawAmount(Long accountNumber,Double amount);
	public void closeAccount(Long accountNumber);
	
}
