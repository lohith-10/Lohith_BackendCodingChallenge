package com.hexaware.managementsystem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDTO {
	
	@NotBlank(message="Player name cannot be empty")
	private String playerName;
	
	@Positive(message="Jersey number must be positive")
	private int jerseyNumber;
	
	@NotBlank(message="Role cannot be empty")
	@Pattern(
		    regexp = "Batsman|Bowler|Keeper|All Rounder",
		    message = "Role must be Batsman, Bowler, Keeper or All Rounder"
		)
	private String role;
	
	private int totalMatches;
	
	private String teamName;
	
	private String countryName;
	
	private String description;

}
