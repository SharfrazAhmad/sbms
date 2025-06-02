package in.ashokit.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "CRICKET_PLAYERS")
public class Player {
	@Id
	@Column(name = "PLAYER-ID")
	private Integer playerId;
	
	@Column(name ="PLAYER_NAME" )
	private String playerName;
	
	@Column(name = "PLAYER_AGE")
	private Integer playerAge;
	
	private String location;

	
	

	
	
	
	
}
