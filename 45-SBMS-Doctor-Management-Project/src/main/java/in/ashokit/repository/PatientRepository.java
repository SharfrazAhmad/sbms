package in.ashokit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ashokit.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient	, Long>{

}
