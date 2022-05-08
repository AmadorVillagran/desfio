package com.modDev.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CharacterDTO {

	private Integer id;
	private String name;
	private String status;
	private String species;
	private String type;
	private Integer episodeCount;
	private OriginDTO origin;
}
