package in.ashokit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class User {
	
	@Id
	private Integer rollNumber;
	private String userName;
	private String userPassword;

	
	@OneToOne
	@JoinColumn(name = "slNo")
	private Laptop laptop;
	
	
}
