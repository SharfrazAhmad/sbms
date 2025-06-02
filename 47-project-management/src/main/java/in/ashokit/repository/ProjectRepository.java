package in.ashokit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long>{

}
