package in.ashokit;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("37-SBMS-Greet-API")
public interface IGreetFiegnClient {

	@GetMapping("/greet")
	public String invokeGreetApi();
}
