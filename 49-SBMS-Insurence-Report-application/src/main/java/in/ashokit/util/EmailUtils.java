package in.ashokit.util;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtils {

    @Autowired
    private JavaMailSender mailSender;

    public boolean sendEmail(String subject, String body, String toAddress, File file) {
        try {
            MimeMessage mimeMsg = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMsg, true);
            helper.setSubject(subject);
            helper.setText(body, true);
            helper.setTo(toAddress);
            
            if (file != null && file.exists()) {
                helper.addAttachment(file.getName(), file);
            }

            mailSender.send(mimeMsg);
            return true;
        } catch (Exception e) {
            e.printStackTrace(); // You can replace this with a logger
            return false;
        }
    }
}
