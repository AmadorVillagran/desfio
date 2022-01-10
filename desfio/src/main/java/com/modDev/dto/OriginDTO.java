package com.modDev.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OriginDTO {

	private String name;
	private String url;
	private String dimension;
	private List<String> residents;
}
