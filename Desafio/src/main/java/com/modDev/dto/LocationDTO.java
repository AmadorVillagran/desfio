package com.modDev.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LocationDTO {

	private Integer id;
	private String name;
	private String type;
	private String dimension;
	private List<String> residents;
	private String url;

}
