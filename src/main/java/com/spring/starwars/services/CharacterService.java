package com.spring.starwars.services;

import com.spring.starwars.dtos.CharacterDTO;
import com.spring.starwars.exceptions.CharacterException;

import java.util.List;

public interface CharacterService {
    public List<CharacterDTO> findCharacters(String name) throws CharacterException;
}
