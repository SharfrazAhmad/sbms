package in.ashokit.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employee_table")
public class Employee {
	
	@Column(name = "emp_id")
	@Id
	@GeneratedValue
	private Integer empId;
	
	@Column(name = "emp_name", updatable = false)
	private String empName;
	
	@Column(name = "emp_salary")
	private Integer empSal;
	
	
}
