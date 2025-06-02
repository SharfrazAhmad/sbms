package in.ashokit.services;

import java.util.List;

import in.ashokit.binding.DashboardResponse;
import in.ashokit.binding.EnquiryForm;
import in.ashokit.binding.EnquirySearchCriteria;

public interface EnquiryService {
	public List<String> getCourseNames();
	public List<String> getEnqStatus();
	public DashboardResponse getDashboardData(Integer userId);
	public String upsertEnquiry(EnquiryForm form);
	public List<EnquiryForm> getEnquiries(Integer userId,EnquirySearchCriteria criteria);

}
