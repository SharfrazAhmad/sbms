package in.ashokit.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClientDto {


	@NotEmpty(message = "First name required")
	private String firstName;
	@NotEmpty(message = "Last name required")
	private String lastName;
	
	private String email;
	private String phone;
	private String address;
	private String status;
}
