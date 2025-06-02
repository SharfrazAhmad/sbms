package in.ashokit.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
@Table(name = "product_master")
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	@Id
	@GeneratedValue
	@Column(name = "product_id")
	private Integer pId;
	@Column(name = "product_name")
	private String pname;
	@Column(name = "product_price")
	private double price;

	@CreationTimestamp
	@Column(name = "created_date", updatable = false)
	private LocalDateTime createdDateTime;

	@UpdateTimestamp
	@Column(name = "updated_date", insertable = false)
	private LocalDateTime updateDateTime;
}
