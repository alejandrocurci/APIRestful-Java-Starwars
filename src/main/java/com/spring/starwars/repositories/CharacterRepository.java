package com.spring.starwars.repositories;

import com.spring.starwars.dtos.CharacterDTO;

import java.util.List;

public interface CharacterRepository {

    public List<CharacterDTO> loadCharacters();
}
