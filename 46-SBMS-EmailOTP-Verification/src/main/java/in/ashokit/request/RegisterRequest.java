package in.ashokit.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegisterRequest {
	private String userName;
	private String email;
	private String password;
}
