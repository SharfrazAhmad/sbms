package in.ashokit.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.entity.Student;
import in.ashokit.respository.IstudentRepository;

@RestController
public class StudentController {

	@Autowired
	IstudentRepository repository;

	@GetMapping("/students")
	public List<Student> getAllStudents() {
		List<Student> students = repository.findAll();
		return students;
	}

	@GetMapping("/students/{id}")
	public Optional<Student> getStudent(@PathVariable int id) {
		Optional<Student> student = repository.findById(id);
		return student;
	}

	@PostMapping("/student/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createStudent(@RequestBody Student student) {
		repository.save(student);
	}

	@PutMapping("/student/update/{id}")
	public Student updateStudent(@PathVariable int id) {
		Student student = repository.findById(id).get();
		student.setName("Ria Somani");
		repository.save(student);
		return student;
	}

	@DeleteMapping("student/delete/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void deleteStudent(@PathVariable int id) {
		repository.deleteById(id);
	}

}
