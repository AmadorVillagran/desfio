package com.modDev.dto.serviceImpl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.modDev.dto.CharacterDTO;
import com.modDev.dto.CharacterResponseDTO;
import com.modDev.dto.LocationDTO;
import com.modDev.dto.OriginDTO;
import com.modDev.dto.service.CharacterService;
import com.modDev.exception.ModDevException;
import com.modDev.util.ConstantMsg;

@Service
public class CharacterServiceImpl implements CharacterService {

	/** The url. */
	@Value("${ws.backend.url}")
	private String url;

	/** The path. */
	@Value("${ws.backend.get.character.id.path}")
	private String getPathCharacterById;

	/** The path. */
	@Value("${ws.backend.get.location.name.path}")
	private String getPathNameById;

	private RestTemplate restTemplate = new RestTemplate();

	@Override
	public CharacterDTO getCharacterById(Integer id) throws ModDevException {
		try {
			ResponseEntity<CharacterResponseDTO> findById = restTemplate.exchange(
					String.format("%s%s", url, getPathCharacterById + id), HttpMethod.GET, null,
					new ParameterizedTypeReference<CharacterResponseDTO>() {
					});
			return CharacterResponseDTOToCharacterDTO(findById.getBody());

		} catch (Exception e) {
			throw new ModDevException(ConstantMsg.CODE_404, ConstantMsg.ERROR_404);
		}
	}

	@Override
	public LocationDTO getLocationByName(String url) throws ModDevException {
		try {
			ResponseEntity<LocationDTO> findByName = restTemplate.exchange(String.format(url), HttpMethod.GET, null,
					new ParameterizedTypeReference<LocationDTO>() {
					});
			return findByName.getBody();

		} catch (Exception e) {
			throw new ModDevException(ConstantMsg.CODE_404, ConstantMsg.ERROR_404);
		}
	}

	private CharacterDTO CharacterResponseDTOToCharacterDTO(CharacterResponseDTO characterResponseDTO)
			throws ModDevException {
		CharacterDTO characterDTO = new CharacterDTO();

		characterDTO.setId(characterResponseDTO.getId());
		characterDTO.setName(characterResponseDTO.getName());
		characterDTO.setSpecies(characterResponseDTO.getStatus());
		characterDTO.setStatus(characterResponseDTO.getStatus());
		characterDTO.setType(characterResponseDTO.getType());
		characterDTO.setEpisodeCount(characterResponseDTO.getEpisode().size());

		characterDTO.setOrigin(new OriginDTO());
		characterDTO.getOrigin().setUrl(characterResponseDTO.getUrl());
		characterDTO.getOrigin().setName(characterResponseDTO.getOrigin().getName());

		LocationDTO locationDTO = getLocationByName(characterResponseDTO.getLocation().getUrl());
		characterDTO.getOrigin().setResidents(locationDTO.getResidents());
		characterDTO.getOrigin().setDimension(locationDTO.getDimension());

		return characterDTO;
	}
}
