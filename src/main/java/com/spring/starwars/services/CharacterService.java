package com.spring.starwars.services;

import com.spring.starwars.dtos.CharacterDTO;
import com.spring.starwars.exceptions.CharacterException;

import java.util.List;
import java.util.Map;

public interface CharacterService {
    public List<CharacterDTO> findCharacters(Map<String, String> params) throws CharacterException;
}
