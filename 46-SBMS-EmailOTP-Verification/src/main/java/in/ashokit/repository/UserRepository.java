package in.ashokit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ashokit.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

//	 static Users findByEmail(String string) {
//		// TODO Auto-generated method stub
//
//	}

}
