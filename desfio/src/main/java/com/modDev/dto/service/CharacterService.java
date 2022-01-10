package com.modDev.dto.service;

import com.modDev.dto.CharacterDTO;
import com.modDev.dto.LocationDTO;
import com.modDev.exception.ModDevException;


public interface CharacterService {

	public CharacterDTO getCharacterById(Integer id) throws ModDevException;
	
	public LocationDTO getLocationByName(String name) throws ModDevException;
}
