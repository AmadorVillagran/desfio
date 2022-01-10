package com.modDev.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CharacterResponseDTO {

	private Integer id;
	private String name;
	private String status;
	private String species;
	private String type;
	private String gender;
	private OriginResponseDTO origin;
	private LocationResponseDTO location;
	private String imagen;
	private List<String> episode;
	private String url;
}
