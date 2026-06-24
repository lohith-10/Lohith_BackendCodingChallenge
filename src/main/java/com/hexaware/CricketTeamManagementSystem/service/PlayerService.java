package com.hexaware.CricketTeamManagementSystem.service;

import java.util.List;

import com.hexaware.CricketTeamManagementSystem.dto.PlayerDTO;

public interface PlayerService {
	
	PlayerDTO addPlayer(PlayerDTO dto);
	
	PlayerDTO updatePlayer(Long playerId, PlayerDTO dto);
	
	PlayerDTO getPlayerById(Long playerId);
	
	List<PlayerDTO> getAllPlayers();
	
	void deletePlayer(Long playerId);

}
