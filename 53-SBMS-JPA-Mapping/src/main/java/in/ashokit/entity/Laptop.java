package in.ashokit.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Laptop {

	@Id
	private Integer slNo;
	private String brand;
	private String batchNumber; 
	
	
	@OneToOne(mappedBy = "laptop", cascade = CascadeType.ALL)
	private User user;

}
