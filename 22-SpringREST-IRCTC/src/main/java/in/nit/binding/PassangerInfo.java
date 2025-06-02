package in.nit.binding;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassangerInfo {
	private String name;
	private Long phNo;
	private String jDate;
	private String from;
	private String to;
	private Integer trainNum;
}
