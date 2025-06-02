package in.ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.Patient;
import in.ashokit.repository.PatientRepository;

@Service
public class PatientService {

	@Autowired
	private PatientRepository repository;

	public List<Patient> getAllPatients() {
		return repository.findAll();
	}
	
	public void savePatient(Patient patient) {
		 repository.save(patient);
	}
	
	public Patient getPatientsById(Long id) {
		Optional<Patient> optional = repository.findById(id);
		return optional.orElse(null);
	}
	
	public void deletePatient(long id) {
		repository.deleteById(id);;
	}
}
