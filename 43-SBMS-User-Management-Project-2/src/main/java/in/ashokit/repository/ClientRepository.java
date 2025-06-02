package in.ashokit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{

	public Client findByEmail(String email);
	
}
