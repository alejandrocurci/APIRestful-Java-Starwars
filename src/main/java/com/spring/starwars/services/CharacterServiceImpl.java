package com.spring.starwars.services;

import com.spring.starwars.dtos.CharacterDTO;
import com.spring.starwars.exceptions.CharacterException;
import com.spring.starwars.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    private CharacterRepository repository;

    @Override
    public List<CharacterDTO> findCharacters(Map<String, String> params) throws CharacterException {
        List<CharacterDTO> characters = repository.loadCharacters();
        if (params.containsKey("name")) {
            filterByName(characters, params.get("name"));
        }
        if (params.containsKey("homeworld")) {
            filterByHomeworld(characters, params.get("homeworld"));
        }
        if (params.containsKey("species")) {
            filterBySpecies(characters, params.get("species"));
        }
        if (characters.isEmpty()) {
            throw new CharacterException("No characters were found");
        }
        return characters;
    }

    public void filterByName(List<CharacterDTO> characters, String name) {
        characters.removeIf(c -> !c.getName().contains(name));
    }

    public void filterByHomeworld(List<CharacterDTO> characters, String homeworld) {
        characters.removeIf(c -> !c.getHomeworld().contains(homeworld));
    }

    public void filterBySpecies(List<CharacterDTO> characters, String species) {
        characters.removeIf(c -> !c.getSpecies().contains(species));
    }

}
