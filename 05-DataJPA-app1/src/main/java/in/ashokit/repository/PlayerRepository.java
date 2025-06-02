package in.ashokit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.ashokit.entity.Player;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Integer>{

}
