package in.ashokit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.dao.IReportDAO;

@Service
public class ReportService {

	private IReportDAO reportDAO;
	
	@Autowired
	public void setReportDAO(IReportDAO reportDAO) {
		System.out.println("setReportDAO method called");
		this.reportDAO = reportDAO;
	}


	public void generateReport() {
		String findData=reportDAO.findData();
		System.out.println("generating report");
	}
	
}
