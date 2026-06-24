package com.hexaware.CricketTeamManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.CricketTeamManagementSystem.entity.Player;

public interface PlayerRepository extends JpaRepository<Player,Long>{

}
