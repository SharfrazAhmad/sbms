package in.ashokit.services;

import in.ashokit.bindings.DashboardCard;
import in.ashokit.bindings.LoginForm;
import in.ashokit.bindings.UserAccForm;

public interface UserService {
	public String login(LoginForm loginForm);
	
	public boolean recoverPwd(String email);
	
	public DashboardCard fetchDashboardInfo();
	
	public UserAccForm getUserByEmail(String email);
}
