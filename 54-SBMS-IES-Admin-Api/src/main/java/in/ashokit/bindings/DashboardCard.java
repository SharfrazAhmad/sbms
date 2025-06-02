package in.ashokit.bindings;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DashboardCard {

	private Long plansCnt;
	private Long approvedCnt;
	private Long deniedCnt;
	private Double beniftAmtGiven;
	
	private UserAccForm user;
}
