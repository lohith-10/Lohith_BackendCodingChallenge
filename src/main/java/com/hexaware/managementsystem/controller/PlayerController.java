package com.hexaware.managementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.managementsystem.dto.PlayerDTO;
import com.hexaware.managementsystem.service.PlayerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/players")
public class PlayerController {
	
	@Autowired
	private PlayerService playerService;
	
	@PostMapping("/add")
	public PlayerDTO addPlayer(@Valid @RequestBody PlayerDTO dto) {
		
		return playerService.addPlayer(dto);
	}
	
	@GetMapping("/allplayers")
	public List<PlayerDTO> getAllPlayers(){
		return playerService.getAllPlayers();
	}
	
	@GetMapping("/allbowlers")
	public List<PlayerDTO> getAllBowlers(){
		
		return playerService.getAllBowlers();
	}
	
	@GetMapping("/{playerId}")
	public PlayerDTO getPlayerById(@PathVariable Long playerId) {
		
		return playerService.getPlayerById(playerId);
	}
	
	@PutMapping("/{playerId}")
	public PlayerDTO updatePlayer(@PathVariable Long playerId, @Valid @RequestBody PlayerDTO dto) {
		
		return playerService.updatePlayer(playerId, dto);	
	}
	
	@DeleteMapping("/{playerId}")
	public void deletePlayer(@PathVariable Long playerId) {
		
		playerService.deletePlayer(playerId);
	}
	
	
	
}
