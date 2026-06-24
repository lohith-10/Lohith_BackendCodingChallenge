package com.hexaware.CricketTeamManagementSystem.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.CricketTeamManagementSystem.dto.PlayerDTO;
import com.hexaware.CricketTeamManagementSystem.entity.Player;
import com.hexaware.CricketTeamManagementSystem.repository.PlayerRepository;
import com.hexaware.CricketTeamManagementSystem.service.PlayerService;

@Service
public class PlayerServiceImpl implements PlayerService{
	
	@Autowired
	private PlayerRepository playerRepository;
	
	public PlayerDTO addPlayer(PlayerDTO dto) {
		
		Player player = new Player();
		
		player.setPlayerName(dto.getPlayerName());
		player.setJerseyNumber(dto.getJerseyNumber());
		player.setRole(dto.getRole());
		player.setTotalMatches(dto.getTotalMatches());
		player.setTeamName(dto.getTeamName());
		player.setCountryName(dto.getCountryName());
		player.setDescription(dto.getDescription());
		
		Player savedPlayer = playerRepository.save(player);
		
		PlayerDTO responseDto = new PlayerDTO();
		
		responseDto.setPlayerName(savedPlayer.getPlayerName());
		responseDto.setJerseyNumber(savedPlayer.getJerseyNumber());
		responseDto.setRole(savedPlayer.getRole());
		responseDto.setTotalMatches(savedPlayer.getTotalMatches());
		responseDto.setTeamName(savedPlayer.getTeamName());
		responseDto.setCountryName(savedPlayer.getCountryName());
		responseDto.setDescription(savedPlayer.getDescription());
		
		return responseDto;
		
	}

	@Override
	public PlayerDTO updatePlayer(Long playerId, PlayerDTO dto) {
		
		Player player = playerRepository.findById(playerId).orElseThrow(null);
		
		player.setPlayerName(dto.getPlayerName());
		player.setJerseyNumber(dto.getJerseyNumber());
		player.setRole(dto.getRole());
		player.setTotalMatches(dto.getTotalMatches());
		player.setTeamName(dto.getTeamName());
		player.setCountryName(dto.getCountryName());
		player.setDescription(dto.getDescription());
		
		Player updatePlayer = playerRepository.save(player);
		
		PlayerDTO responseDto = new PlayerDTO();
		
		responseDto.setPlayerName(updatePlayer.getPlayerName());
		responseDto.setJerseyNumber(updatePlayer.getJerseyNumber());
		responseDto.setRole(updatePlayer.getRole());
		responseDto.setTotalMatches(updatePlayer.getTotalMatches());
		responseDto.setTeamName(updatePlayer.getTeamName());
		responseDto.setCountryName(updatePlayer.getCountryName());
		responseDto.setDescription(updatePlayer.getDescription());
		
		return responseDto;
		
	}

	@Override
	public PlayerDTO getPlayerById(Long playerId) {
		
		Player player = playerRepository.findById(playerId)
		        .orElseThrow(() -> new RuntimeException());
		
		PlayerDTO dto = new PlayerDTO();
		
		dto.setPlayerName(player.getPlayerName());
		dto.setJerseyNumber(player.getJerseyNumber());
		dto.setRole(player.getRole());
		dto.setTotalMatches(player.getTotalMatches());
		dto.setTeamName(player.getTeamName());
		dto.setCountryName(player.getCountryName());
		dto.setDescription(player.getDescription());
		
		return dto;
		
	}

	@Override
	public List<PlayerDTO> getAllPlayers() {
		List<Player> players = playerRepository.findAll();
		
		List<PlayerDTO> dtoList = new ArrayList<>();
		
		for(Player player : players) {
			
			PlayerDTO dto = new PlayerDTO();
			
			dto.setPlayerName(player.getPlayerName());
			dto.setJerseyNumber(player.getJerseyNumber());
			dto.setRole(player.getRole());
			dto.setTotalMatches(player.getTotalMatches());
			dto.setTeamName(player.getTeamName());
			dto.setCountryName(player.getCountryName());
			dto.setDescription(player.getDescription());
			
			dtoList.add(dto);
			
		}
		return dtoList;
	}

	@Override
	public void deletePlayer(Long playerId) {
		playerRepository.deleteById(playerId);
		
	}

}
