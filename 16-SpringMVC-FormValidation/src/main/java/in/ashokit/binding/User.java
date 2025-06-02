package in.ashokit.binding;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@NotEmpty(message = "required")
	private String uname;
	private String pwd;
	private String email;
	private Long phno;
	private Integer age;
}
