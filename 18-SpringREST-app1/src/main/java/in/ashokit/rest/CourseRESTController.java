package in.ashokit.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseRESTController {

	@GetMapping("/course")
	public ResponseEntity<String> getCourse(@RequestParam("cname") String cname,@RequestParam("tname") String tname){
		String resBody=cname	+" :Course \n"+tname+" :trainer";
		return new ResponseEntity<String>(resBody, HttpStatus.OK);
	}
}
