package in.ashokit.bindings;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlanForm {

	private String planCategory;
    private String planName;
    private LocalDate planStartDate;
    private LocalDate planEndDate;
}
