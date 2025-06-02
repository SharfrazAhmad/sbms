package in.ashokit.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.binding.LoginForm;
import in.ashokit.binding.SignUpForm;
import in.ashokit.binding.UnlockForm;
import in.ashokit.entity.UserDtlsEntity;
import in.ashokit.repo.UserDtlsRepo;
import in.ashokit.utility.EmailUtils;
import in.ashokit.utility.PwdUtils;

@Service
public class UserServiceImpl implements UserServices {

	@Autowired
	private PwdUtils pwdUtils;
	
	@Autowired
	private UserDtlsRepo userDtlsRepo;
	
	@Autowired
	private EmailUtils emailUtils;
	
	@Override
	public boolean signUp(SignUpForm form) {
		UserDtlsEntity user = userDtlsRepo.findByEmail(form.getEmail());
		if(user!=null) {
			return false;
		}
		
//		copy data from binding obj to entity obj
		UserDtlsEntity entity = new UserDtlsEntity();
		BeanUtils.copyProperties(form, entity);
		
//		generate random pwd
		String temPwd = pwdUtils.generateRandomPwd();
		entity.setPwd(temPwd);
		
//		Set account Status Status locked
		entity.setAccStatus("Locked");
		
//		insert record
		userDtlsRepo.save(entity);
		
//		send email to unlock the account
		String to = form.getEmail();
		String subject = "Unlock Your Account";
		StringBuffer body = new StringBuffer();

		body.append("<div style='font-family: Arial, sans-serif; padding: 20px; background-color: #f9f9f9;'>");

		body.append("<div style='max-width: 600px; margin: auto; background-color: #ffffff; border-radius: 8px; box-shadow: 0 2px 8px rgba(0,0,0,0.1); padding: 30px;'>");

		body.append("<h2 style='color: #c94bdb; text-align: center;'>Unlock Your Account</h2>");
		body.append("<p style='font-size: 16px; color: #333;'>Hello,</p>");
		body.append("<p style='font-size: 16px; color: #333;'>We received a request to unlock your account. Please use the temporary password below to proceed:</p>");

		body.append("<div style='font-size: 18px; font-weight: bold; color: #f12711; background-color: #fce3e3; padding: 10px 15px; border-radius: 5px; text-align: center; margin: 20px 0;'>");
		body.append("Temporary Password: <span>" + temPwd + "</span>");
		body.append("</div>");

		body.append("<p style='font-size: 16px; color: #333;'>Click the link below to unlock your account:</p>");

		body.append("<div style='text-align: center; margin: 20px 0;'>");
		body.append("<a href=\"http://localhost:8080/unlock?email=" + to + "\" style='display: inline-block; padding: 12px 20px; background-color: #c94bdb; color: white; text-decoration: none; border-radius: 5px;'>");
		body.append("Unlock Account</a>");
		body.append("</div>");

		body.append("<p style='font-size: 14px; color: #999;'>If you didn’t request this, please ignore this email.</p>");

		body.append("<p style='font-size: 14px; color: #999; margin-top: 30px;'>Thanks,<br>The Ashok IT Team</p>");

		body.append("</div>");
		body.append("</div>");

		
		emailUtils.sendEmail(to, subject, body.toString());
		return true;
	}

	@Override
	public String login(LoginForm form) {
		UserDtlsEntity entity = userDtlsRepo.findByEmailAndPwd(form.getEmail(), form.getPwd());
		if(entity==null) {
			return "Invalid Credentials";
		}
		else if (entity.getAccStatus().equals("Locked")) {
			return "Account is Locked";
		}
		return "success";
	}

	@Override
	public boolean unlockAccount(UnlockForm form) {
		UserDtlsEntity entity = userDtlsRepo.findByEmail(form.getEmail());
		if(entity.getPwd().equals(form.getTempPwd())) {
			entity.setPwd(form.getNewPwd());
			entity.setAccStatus("Unlocked");
			userDtlsRepo.save(entity);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean forgotPwd(String email) {
		UserDtlsEntity entity = userDtlsRepo.findByEmail(email);
		
		if(entity==null) {
			return false;
		}
		
		String subject="Recover Password";
		String body="Password: "+entity.getPwd();
		emailUtils.sendEmail(email, subject, body);
		
		return true;
	}

}
