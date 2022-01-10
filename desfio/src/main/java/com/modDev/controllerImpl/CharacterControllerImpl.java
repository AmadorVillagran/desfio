package com.modDev.controllerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.modDev.controller.CharacterController;
import com.modDev.dto.CharacterDTO;
import com.modDev.dto.service.CharacterService;
import com.modDev.exception.ModDevException;

@RestController
public class CharacterControllerImpl implements CharacterController{

	@Autowired
	private CharacterService characterService;
	
	@Override
	public CharacterDTO getCharacterById(Integer id) throws ModDevException {
		return characterService.getCharacterById(id);
	}

}
