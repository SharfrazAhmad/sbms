package in.ashokit.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

@Entity
@Table
public class Users {

	private Long userId;
	private String userName;
	private String email;
	private String password;
	private boolean verified;
}
