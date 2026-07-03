package com.hexaware.managementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hexaware.managementsystem.entity.Player;

public interface PlayerRepository extends JpaRepository<Player,Long>{
	
	@Query("Select p from Player p where p.role = 'Bowler'")
	List<Player> getAllBowlers();
}
