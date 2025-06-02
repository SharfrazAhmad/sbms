package in.ashokit.bindings;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UnlockAccForm {

	private String email;
    private String tempPwd;
    private String newPwd;
    private String confirmPwd;
}
