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
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "user_master")
@Entity
public class User {

	@Id
	@Column(name = "user_id")
	private Integer userId;
	@Column(name = "user_age")
	private Integer userAge;
	@Column(name = "user_country")
	private String userCountry;
	@Column(name = "user_gender")
	private String userGender;
	@Column(name = "user_name")
	private String userName;

}
