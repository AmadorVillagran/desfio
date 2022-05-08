package com.modDev.controller.service;

import static org.mockito.Mockito.validateMockitoUsage;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.modDev.dto.CharacterResponseDTO;
import com.modDev.dto.LocationDTO;
import com.modDev.dto.service.CharacterService;
import com.modDev.exception.ModDevException;

public class CharacterServiceTest {
	@InjectMocks
	private  CharacterService CharacterService;

	@Mock
	private RestTemplate restTemplate;

	/** The url. */
	@Value("${ws.backend.url}")
	private String url;

	/** The path. */
	@Value("${ws.backend.get.character.id.path}")
	private String getPathCharacterById;

	/** The path. */
	@Value("${ws.backend.get.location.name.path}")
	private String getPathNameById;
	
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
		ResponseEntity<CharacterResponseDTO> response = new ResponseEntity<CharacterResponseDTO>(new CharacterResponseDTO(),
				HttpStatus.ACCEPTED);
		
		ResponseEntity<LocationDTO> location = new ResponseEntity<LocationDTO>(new LocationDTO(),
				HttpStatus.ACCEPTED);

		Mockito.when(restTemplate.exchange(Mockito.eq(String.format("%s%s", url, getPathCharacterById + Mockito.anyInt())),
				Mockito.eq(HttpMethod.GET), Mockito.eq(null), Mockito.<ParameterizedTypeReference<CharacterResponseDTO>>any()))
				.thenReturn(response);

		Mockito.when(restTemplate.exchange(Mockito.anyString(),
				Mockito.eq(HttpMethod.GET), Mockito.eq(null), Mockito.<ParameterizedTypeReference<LocationDTO>>any()))
				.thenReturn(location);
		
		assertNotNull(CharacterService.getCharacterById(Mockito.anyInt()));
	}
}
