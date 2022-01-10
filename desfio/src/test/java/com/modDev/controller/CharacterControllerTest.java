package com.modDev.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.validateMockitoUsage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.modDev.dto.CharacterDTO;
import com.modDev.dto.service.CharacterService;
import com.modDev.exception.ModDevException;

public class CharacterControllerTest {
	
	@InjectMocks
	private  CharacterController characterController;

	@Mock
	private  CharacterService characterService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@AfterEach
	void tearDown() {
		validateMockitoUsage();
	}
	
	@Test
	void getCharacterById() throws ModDevException {
		Mockito.when(characterService.getCharacterById(Mockito.anyInt())).thenReturn(new CharacterDTO());
		assertNotNull(characterController.getCharacterById(Mockito.anyInt()));
	}
}
