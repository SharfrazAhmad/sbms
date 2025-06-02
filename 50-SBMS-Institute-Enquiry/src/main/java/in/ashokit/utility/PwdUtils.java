package in.ashokit.utility;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Component;

@Component
public class PwdUtils {
public String  generateRandomPwd() {
	String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String num = "0123456789";
    String specialChar = "!@#%";
    String combination = upper + upper.toLowerCase() + num + specialChar;
    int len = 6;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < len; i++) {
        sb.append(combination.charAt(
                ThreadLocalRandom.current().nextInt(
                        combination.length()
                )
        ));
    }
    return sb.toString();
}
}
