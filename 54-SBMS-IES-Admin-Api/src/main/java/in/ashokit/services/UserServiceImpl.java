package in.ashokit.services;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.bindings.DashboardCard;
import in.ashokit.bindings.LoginForm;
import in.ashokit.bindings.UserAccForm;
import in.ashokit.constants.AppConstants;
import in.ashokit.entities.EligEntity;
import in.ashokit.entities.UserEntity;
import in.ashokit.repositories.EligRepo;
import in.ashokit.repositories.PlanRepo;
import in.ashokit.repositories.UserRepo;
import in.ashokit.utils.EmailUtils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private PlanRepo planRepo;

	@Autowired
	private EmailUtils emailUtils;

	@Autowired
	private EligRepo eligRepo;

	@Override
	public String login(LoginForm loginForm) {

		UserEntity entity = userRepo.findByEmailAndPwd(loginForm.getEmail(), loginForm.getPwd());
		if (entity == null) {
			return "Invalid Credentials";
		}
		if ("Y".equals(entity.getActiveSw()) && "UNLOCKED".equals(entity.getAccStatus())) {
			return "Success";
		}
		
		if ("UNLOCKED".equals(entity.getAccStatus())) {
			return "Success@role="+entity.getRoleId();
		} else {
			return "Account Locked";
		}
	}

	 @Override
	    public boolean recoverPwd(String email) {
	        UserEntity userEntity = userRepo.findByEmail(email);
	        if(null == userEntity){
	            return false;
	        }else{
	        	String subject = AppConstants.RECOVER_SUB;
	    		String body = readEmailBody(AppConstants.PWD_BODY_FILE, userEntity);
	          return emailUtils.sendEmail(subject, body, email);
	        }
	    }

	@Override
	public DashboardCard fetchDashboardInfo() {

		long planCount = planRepo.count();

		List<EligEntity> eligList = eligRepo.findAll();

		long approvedCnt = eligList.stream().filter(ed -> ed.getPlanStatus().equals("AP")).count();
		long deniedCnt = eligList.stream().filter(ed -> ed.getPlanStatus().equals("DN")).count();
		double total = eligList.stream().mapToDouble(ed -> ed.getBenefitAmt()).sum();

		DashboardCard card = new DashboardCard();
		card.setPlansCnt(planCount);
		card.setApprovedCnt(approvedCnt);
		card.setDeniedCnt(deniedCnt);
		card.setBeniftAmtGiven(total);

		return card;
	}

	@Override
	public UserAccForm getUserByEmail(String email) {
		UserEntity userEntity = userRepo.findByEmail(email);
		UserAccForm user = new UserAccForm();
		BeanUtils.copyProperties(userEntity, user);
		return user;
	}
	
	private String readEmailBody(String filename, UserEntity user) {
		StringBuilder sb = new StringBuilder();
		try (Stream<String> lines = Files.lines(Paths.get(filename))) {
			lines.forEach(line -> {
				line = line.replace(AppConstants.FNAME, user.getFullName());
				line = line.replace(AppConstants.PWD, user.getPwd());
				line = line.replace(AppConstants.EMAIL, user.getEmail());
				sb.append(line);
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

}
