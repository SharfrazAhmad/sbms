package in.ashokit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.Laptop;

public interface LaptopRepo extends JpaRepository<Laptop, Integer>{

}
