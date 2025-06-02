package in.ashokit.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.Student;

public interface IstudentRepository extends JpaRepository<Student, Integer>{

}
