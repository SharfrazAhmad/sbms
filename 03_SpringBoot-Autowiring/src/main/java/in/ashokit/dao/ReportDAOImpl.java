package in.ashokit.dao;

import org.springframework.stereotype.Repository;

@Repository
public class ReportDAOImpl implements IReportDAO{

	public ReportDAOImpl() {
		System.out.println("Report DAO imp Constructor");
	}

	
	@Override
	public String findData() {
		System.out.println("fetching from db");
		return "report data";
	}
	

	
}
