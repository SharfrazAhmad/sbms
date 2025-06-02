package in.ashokit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.Account;

public interface IAccountRepository extends JpaRepository<Account, Long> {

}
