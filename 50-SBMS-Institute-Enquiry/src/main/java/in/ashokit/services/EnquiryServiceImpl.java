package in.ashokit.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.binding.DashboardResponse;
import in.ashokit.binding.EnquiryForm;
import in.ashokit.binding.EnquirySearchCriteria;
import in.ashokit.entity.StudentEnqEntity;
import in.ashokit.entity.UserDtlsEntity;
import in.ashokit.repo.UserDtlsRepo;
@Service
public class EnquiryServiceImpl implements EnquiryService {

	@Autowired
	private UserDtlsRepo userDtlsRepo;
	
	@Override
	public List<String> getCourseNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getEnqStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DashboardResponse getDashboardData(Integer id) {
		DashboardResponse response = new DashboardResponse();
		
		Optional<UserDtlsEntity> findById = userDtlsRepo.findById(id);
		if(findById.isPresent()) {
			UserDtlsEntity userEntity = findById.get();
			List<StudentEnqEntity> enquiries = userEntity.getEnquiries();
			Integer totalCnt = enquiries.size();
			
			List<StudentEnqEntity> enrolled = enquiries.stream().filter(e->e.getEnqStatus().equals("ENROLLED")).collect(Collectors.toList());
			Integer enrolledCnt = enrolled.size();
			
			List<StudentEnqEntity> lost = enquiries.stream().filter(e->e.getEnqStatus().equals("LOST")).collect(Collectors.toList());
			Integer lostCnt = lost.size();
			
			response.setTotalEnquiriesCnt(totalCnt);
			response.setEnrolledCnt(enrolledCnt);
			response.setLostCnt(lostCnt);
		}
		
		
		return response;
	}

	@Override
	public String upsertEnquiry(EnquiryForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EnquiryForm> getEnquiries(Integer userId, EnquirySearchCriteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}

}
