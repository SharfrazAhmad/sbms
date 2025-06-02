package in.ashokit.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="user_master")
public class User {

	@Id
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name = "user_name")
	private String username;
	
	@Column(name="user_gender")
	private String gender;
	
	@Column(name = "user_age")
	private Integer age;
	
	@Column(name = "user_country")
	private String country;
	
}
