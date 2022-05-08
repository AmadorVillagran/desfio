package com.modDev.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.modDev.dto.CharacterDTO;
import com.modDev.exception.ModDevException;

@RequestMapping("/character")
public interface CharacterController {

	@GetMapping(value ="/findById/{id}")
	public CharacterDTO getCharacterById(@PathVariable(value = "id") Integer id) throws ModDevException;
}
