package com.hexaware.managementsystem.service;

import java.util.List;

import com.hexaware.managementsystem.dto.PlayerDTO;

public interface PlayerService {
	
	PlayerDTO addPlayer(PlayerDTO dto);
	
	PlayerDTO updatePlayer(Long playerId, PlayerDTO dto);
	
	PlayerDTO getPlayerById(Long playerId);
	
	List<PlayerDTO> getAllPlayers();
	
	List<PlayerDTO> getAllBowlers();
	
	void deletePlayer(Long playerId);

}
