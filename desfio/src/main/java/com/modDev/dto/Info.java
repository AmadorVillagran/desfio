package com.modDev.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Info {

	private Integer count;
	private Integer pages;
	private Integer next;
	private Integer prev;

}
