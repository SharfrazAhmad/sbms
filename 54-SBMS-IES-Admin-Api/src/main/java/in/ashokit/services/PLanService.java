package in.ashokit.services;

import java.util.List;

import in.ashokit.bindings.PlanForm;

public interface PLanService {

	public boolean createPlan(PlanForm planForm);
	
	public List< PlanForm> fetchPlan();
	
	public PlanForm getPlanById(Integer planId);
	
	public String changePlanStatus(Integer planId,String status);
}
